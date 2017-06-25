package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Student;
import ir.sbu.golestan.domain.StudentTerm;
import ir.sbu.golestan.domain.Term;

/**
 * Created by Ali Asghar on 25/06/2017.
 */
public interface StudentTermRepository extends PagingAndSortingRepositoryWithSpecifications<StudentTerm, Long> {
    StudentTerm findByStudentAndTerm(Student student, Term term);
}
