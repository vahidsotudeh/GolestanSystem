package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Course;
import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.Student;
import ir.sbu.golestan.domain.StudentLecture;
import ir.sbu.golestan.service.LectureService;
import ir.sbu.golestan.service.StudentLectureService;
import ir.sbu.golestan.service.StudentService;
import ir.sbu.golestan.service.TermService;
import ir.sbu.golestan.util.DateUtil;
import ir.sbu.golestan.util.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * Created by Ali Asghar on 22/06/2017.
 */
@RestController
@RequestMapping("api/register")
public class RegisterController {

    @Autowired
    SecurityHelper securityHelper;

    @Autowired
    LectureService lectureService;

    @Autowired
    TermService termService;

    @Autowired
    StudentLectureService studentLectureService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/addLecture", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity addLecture(@RequestParam("lectureId") Long lectureID) {

        if (securityHelper.hasUpdatePermission(Student.class.getSimpleName())
                && securityHelper.hasUpdatePermission(StudentLecture.class.getSimpleName())
                && securityHelper.hasUpdatePermission(Lecture.class.getSimpleName())
                && securityHelper.hasAuthority("ROLE_STUDENT")) {

            if (canAdd(lectureID)) {
                StudentLecture sl = new StudentLecture();
                Student s = studentService.get(securityHelper.getCurrentUser().getId());
                sl.setStudent(s);
                Lecture l = lectureService.get(lectureID);
                sl.setLecture(l);
                s.getStudentLectures().add(sl);
                l.getStudentLectures().add(sl);
                studentLectureService.add(sl);
                studentService.update(s);
                lectureService.update(l);
                return ResponseEntity.status(HttpStatus.OK).body("added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unit count exceeds");
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("you don't have permission");
    }

    private boolean canAdd(long lectureID) {
        return isAVGOK(lectureID) && isPreRequiredOK(lectureID);
    }

    private boolean isPreRequiredOK(long lectureID) {
        Course current = lectureService.get(lectureID).getCourse();
        Set<Course> preRequiredCourses = current.getPreRequiredCourses();
        for (Lecture l : lectureService.getAdoptedLectures(securityHelper.getCurrentUser())) {
            for (Course c :
                    preRequiredCourses) {
                if (c.equals(l.getCourse()))
                    return true;
            }
        }
        return false;
    }

    private boolean isAVGOK(long lectureID){
        int year = DateUtil.getYear();
        int semester = DateUtil.getSemester();
        int adoptedUnits = lectureService.getAdoptedUnits(securityHelper.getCurrentUser(), termService.getTerm(year, semester));
        int adoptingCourseUnit = lectureService.get(lectureID).getCourse().getPracticalUnitCount()
                + lectureService.get(lectureID).getCourse().getTheoreticalUnitCount();
        if (semester == 2) {
            semester = 1;
        } else {
            year -= 1;
            semester = 2;
        }
        float avg = studentLectureService.getAvg(securityHelper.getCurrentUser(), termService.getTerm(year, semester));
//        float avg = studentLectureService.getAvg(securityHelper.getCurrentUser(), termService.getTerm(1380, 1));

        if (avg > 17) {
            if (adoptedUnits + adoptingCourseUnit < 24)
                return true;
        } else {
            if (adoptedUnits + adoptingCourseUnit < 20)
                return true;
        }

        return false;
    }

}