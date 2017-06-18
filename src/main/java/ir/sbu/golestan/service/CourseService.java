package ir.sbu.golestan.service;

import ir.sbu.golestan.repository.CourseRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@Component
@Service
public class CourseService extends AbstractPagingAndSortingEntityService {
    @Autowired
    public CourseService(CourseRepository repository){
        super.r = repository;
    }
}
