package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.Master;
import ir.sbu.golestan.dto.LectureFullDTO;
import ir.sbu.golestan.service.LectureService;
import ir.sbu.golestan.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/lectures")
public class LectureController extends AbstractPagingAndSortingController<Lecture, LectureFullDTO> {

    @Autowired
    MasterService masterService;

    @Autowired
    public LectureController(LectureService service){
        super.s = service;
        super.eClass = Lecture.class;
        super.dClass = LectureFullDTO.class;
    }

    @GetMapping("master/{masterId}")
    public ResponseEntity getMasterLectures(@PathVariable("masterId") Long masterId){
        if(securityHelper.hasReadPermission(Lecture.class.getSimpleName())) {
            Master m = masterService.get(masterId);
            Set<Lecture> lectures = m.getLectures();
            List<LectureFullDTO> response = new ArrayList<>();
            for (Lecture l : lectures) {
                response.add(convertToDto(l));
            }
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("you don't have permission");
    }

    @GetMapping("master/current")
    public ResponseEntity getCurrentMasterLectures(){
        return getMasterLectures(securityHelper.getCurrentUser().getId());
    }
}
