package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.repository.LectureRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ali Asghar on 02/06/2017.
 */
@Service
@Component
public class LectureService extends AbstractPagingAndSortingEntityService<Lecture> {

    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        super.r = lectureRepository;
    }
}
