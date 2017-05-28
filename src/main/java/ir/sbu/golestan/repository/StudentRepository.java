package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}
