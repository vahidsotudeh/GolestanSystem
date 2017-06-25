package ir.sbu.golestan.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.sbu.golestan.domain.*;
import ir.sbu.golestan.dto.MasterFullDTO;
import ir.sbu.golestan.service.LectureService;
import ir.sbu.golestan.service.MasterService;
import ir.sbu.golestan.service.StudentLectureService;
import ir.sbu.golestan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/masters")
public class MasterController extends AbstractPagingAndSortingController<Master, MasterFullDTO> {

    @Autowired
    StudentService studentService;

    @Autowired
    LectureService lectureService;

    @Autowired
    StudentLectureService studentLectureService;

    @Autowired
    public MasterController(MasterService service) {
        super.s = service;
        super.eClass = Master.class;
        super.dClass = MasterFullDTO.class;
    }

    @PostMapping("/submitGrade")
    public ResponseEntity submitGrade(@RequestBody GradeDTO grade) {
        if(securityHelper.hasRole(Role.RoleTypes.MASTER.name())) {

            if (grade == null || grade.lectureId == 0 || grade.studentId == 0 || grade.grade == 0)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("some fields are not present");

            Student s = studentService.get(grade.studentId);
            Lecture l = lectureService.get(grade.lectureId);
            StudentLecture sl = new StudentLecture();
            sl.setLecture(l);
            sl.setStudent(s);
            sl.setGrade(grade.grade);
            studentLectureService.add(sl);
            s.getStudentLectures().add(sl);
            studentService.update(s);
            l.getStudentLectures().add(sl);
            lectureService.update(l);

            return ResponseEntity.ok("added grade successfully");
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("you don't have permission");
        }
    }

    public class GradeDTO {
        @JsonProperty
        Long lectureId;
        @JsonProperty
        Long studentId;
        @JsonProperty
        float grade;
    }

}
