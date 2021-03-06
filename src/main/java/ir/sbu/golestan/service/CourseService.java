package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.Course;
import ir.sbu.golestan.repository.CourseRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ali Asghar on 02/06/2017.
 */
@Service
@Component
public class CourseService extends AbstractPagingAndSortingEntityService<Course> {

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        super.r = courseRepository;
    }
}
