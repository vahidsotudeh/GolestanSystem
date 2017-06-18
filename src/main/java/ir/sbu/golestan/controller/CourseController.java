package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Course;
import ir.sbu.golestan.dto.CourseDTO;
import ir.sbu.golestan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/courses")
public class CourseController extends AbstractPagingAndSortingController {

    @Autowired
    public CourseController(CourseService service){
        super.s = service;
        super.eClass = Course.class;
        super.dClass = CourseDTO.class;
    }
}
