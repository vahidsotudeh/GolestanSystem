package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
