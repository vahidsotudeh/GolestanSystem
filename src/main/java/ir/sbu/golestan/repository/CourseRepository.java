package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Course;

/**
 * Created by Ali Asghar on 22/05/2017.
 */


public interface CourseRepository extends PagingAndSortingRepositoryWithSpecifications<Course, Long> {
    Course findByName(String name);
    Course findByCode(String code);
}
