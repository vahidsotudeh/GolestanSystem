package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.Term;
import ir.sbu.golestan.repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Service
@Controller
public class TermService extends AbstractPagingAndSortingEntityService {
    @Autowired
    public TermService(TermRepository repository){
        super.r = repository;
    }

    public Term getTerm(int year, int semester){
        return ((TermRepository)r).findByYearAndAndSemester(year, semester);
    }

    public Iterable<Term> getFinishedTerms(){
        return ((TermRepository)r).findByFinished(true);
    }
}
