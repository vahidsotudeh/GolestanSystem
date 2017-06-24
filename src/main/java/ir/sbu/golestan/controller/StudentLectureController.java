package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.StudentLecture;
import ir.sbu.golestan.dto.StudentLectureDTO;
import ir.sbu.golestan.service.StudentLectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/studentLecture")
public class StudentLectureController extends AbstractPagingAndSortingController<StudentLecture, StudentLectureDTO> {

    @Autowired
    public StudentLectureController(StudentLectureService service){
        super.s = service;
        super.eClass = StudentLecture.class;
        super.dClass = StudentLectureDTO.class;
    }
}
