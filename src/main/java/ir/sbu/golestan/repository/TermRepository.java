package ir.sbu.golestan.repository;

import ir.sbu.golestan.domain.Term;
import org.springframework.stereotype.Repository;

/**
 * Created by Ali Asghar on 22/05/2017.
 */
@Repository
public interface TermRepository extends PagingAndSortingRepositoryWithSpecifications<Term, Long> {
    Term findByYearAndAndSemester(int year, int semester);
}
