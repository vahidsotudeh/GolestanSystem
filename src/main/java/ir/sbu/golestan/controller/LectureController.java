package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.dto.LectureFullDTO;
import ir.sbu.golestan.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/lectures")
public class LectureController extends AbstractPagingAndSortingController<Lecture, LectureFullDTO> {

    @Autowired
    public LectureController(LectureService service){
        super.s = service;
        super.eClass = Lecture.class;
        super.dClass = LectureFullDTO.class;
    }
}
