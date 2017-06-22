package ir.sbu.golestan.service;

import ir.sbu.golestan.repository.Course1Repository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Component
@Service
public class LectureService extends AbstractPagingAndSortingEntityService {
    @Autowired
    public LectureService(Course1Repository repository){
        super.r = repository;
    }
}
