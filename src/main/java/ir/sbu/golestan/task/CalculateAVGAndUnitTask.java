package ir.sbu.golestan.task;

import ir.sbu.golestan.domain.StudentTerm;
import ir.sbu.golestan.domain.Term;
import ir.sbu.golestan.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Ali Asghar on 25/06/2017.
 */
@Component
public class CalculateAVGAndUnitTask {

    @Autowired
    private TermService termService;

    @Scheduled(fixedRate = 1000000)
    public void doTask(){
        for (Term term : termService.getFinishedTerms()) {
            for (StudentTerm st: term.getStudentTerms()) {
                
            }
        }
    }
}
