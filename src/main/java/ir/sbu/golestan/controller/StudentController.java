package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.Student;
import ir.sbu.golestan.domain.StudentLecture;
import ir.sbu.golestan.dto.StudentFullDTO;
import ir.sbu.golestan.service.LectureService;
import ir.sbu.golestan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali Asghar on 25/06/2017.
 */

@RestController
@RequestMapping("/api/students")
public class StudentController extends AbstractPagingAndSortingController<Student, StudentFullDTO> {

    @Autowired
    LectureService lectureService;

    @Autowired
    public StudentController(StudentService studentService){
        super.s = studentService;
        super.eClass = Student.class;
        super.dClass = StudentFullDTO.class;
    }

    @GetMapping("/lecture/{lectureId}")
    public ResponseEntity getLectureStudents(@PathVariable("lectureId") Long lectureId){
        Lecture lecture = lectureService.get(lectureId);
        List<Student> students = new ArrayList<>();
        List<StudentFullDTO> response = new ArrayList<>();
        for (StudentLecture sl :
                lecture.getStudentLectures()) {
              students.add(sl.getStudent());
        }
        for (Student s:
             students) {
            response.add(convertToDto(s));
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
