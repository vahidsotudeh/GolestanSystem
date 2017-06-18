package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.StudentCourse;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
public interface StudentCourseRepository extends PagingAndSortingRepository<StudentCourse, Long> {
}
