package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ali Asghar on 22/05/2017.
 */


public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    Course findByName(String name);
    Course findByCode(String code);
}
