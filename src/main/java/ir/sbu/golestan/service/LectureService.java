package ir.sbu.golestan.service;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.repository.LectureRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by Ali Asghar on 02/06/2017.
 */
@Service
public class LectureService {
    @Autowired
    LectureRepository lectureRepository;

    public List<Lecture> getLectures(int page, int size, String sortDir, String sort){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDir), sort);
        return  lectureRepository.findAll(pageRequest).getContent();
    }
}
