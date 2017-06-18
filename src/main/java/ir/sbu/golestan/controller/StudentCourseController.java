package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.StudentCourse;
import ir.sbu.golestan.dto.StudentCourseDTO;
import ir.sbu.golestan.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/studentCourse")
public class StudentCourseController extends AbstractPagingAndSortingController {

    @Autowired
    public StudentCourseController(StudentCourseService service){
        super.s = service;
        super.eClass = StudentCourse.class;
        super.dClass = StudentCourseDTO.class;
    }
}
