package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.dto.LectureDTO;
import ir.sbu.golestan.dto.PreRequiredLectureDTO;
import ir.sbu.golestan.repository.LectureRepository;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@Controller
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<LectureDTO> getLectures(@RequestParam("start") Optional<String> start, @RequestParam("size") Optional<String> size){
        List<Lecture> lectures;
        try{
            Pageable pageable = new PageRequest(Integer.valueOf(start.get()), Integer.valueOf(size.get()));
            lectures = Lists.newArrayList(lectureRepository.findAll(pageable));
        }catch (NoSuchElementException e){
            lectures = Lists.newArrayList(lectureRepository.findAll());
        }

        List<LectureDTO> dtos = new ArrayList<>();
        for(Lecture l: lectures){
            dtos.add(getDTO(l));
        }
        return dtos;
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody LectureDTO getLecture(@PathVariable("id") Long id){
        return getDTO(lectureRepository.findOne(id));
    }

    private LectureDTO getDTO(Lecture l){
        LectureDTO dto = new LectureDTO();
        dto.setId(l.getId());
        dto.setName(l.getName());
        dto.setPracticalUnitCount(l.getPracticalUnitCount());
        dto.setSubGroups(l.getSubGroups());
        dto.setTheoreticalUnitCount(l.getTheoreticalUnitCount());
        for(Lecture lec: l.getPreRequiredLectures()){
            dto.getPreRequiredLectures().add(new PreRequiredLectureDTO(lec.getId(), lec.getName()));
        }
        dto.setCode(l.getCode());
        return dto;
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            lectureRepository.delete(id);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity addLecture(@RequestBody LectureDTO dto){

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
