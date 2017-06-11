package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.dto.LectureFullDTO;
import ir.sbu.golestan.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lectures")
public class LectureController extends AbstractPagingAndSortingController<Lecture, LectureFullDTO> {

    @Autowired
    public LectureController(LectureService lectureService) {
        super.s = lectureService;
        super.dClass = LectureFullDTO.class;
        super.eClass = Lecture.class;
    }

}
