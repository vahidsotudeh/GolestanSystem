package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.repository.LectureRepository;
import ir.sbu.golestan.util.PageHelper;
import ir.sbu.golestan.util.PageParams;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ali Asghar on 02/06/2017.
 */
@Service
@Component
public class LectureService {
    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    PageHelper pageHelper;

    public List<Lecture> getLectures(PageParams pageParams){
        PageRequest pageRequest = pageHelper.getPageRequest(pageParams);
        return  lectureRepository.findAll(pageRequest).getContent();
    }
}
