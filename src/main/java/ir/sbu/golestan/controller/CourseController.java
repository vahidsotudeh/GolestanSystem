package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Course;
import ir.sbu.golestan.dto.CourseFullDTO;
import ir.sbu.golestan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 28/05/2017.
 */

@RestController
@RequestMapping("api/courses")
public class CourseController extends AbstractPagingAndSortingController<Course, CourseFullDTO> {

    @Autowired
    public CourseController(CourseService courseService) {
        super.s = courseService;
        super.dClass = CourseFullDTO.class;
        super.eClass = Course.class;
    }

}
