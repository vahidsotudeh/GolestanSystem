package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.dto.LectureDTO;
import ir.sbu.golestan.repository.LectureRepository;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
            LectureDTO dto = new LectureDTO();
            dto.setId(l.getId());
            dto.setName(l.getName());
            dto.setPracticalUnitCount(l.getPracticalUnitCount());
            dto.setSubGroups(l.getSubGroups());
            dto.setTheoreticalUnitCount(l.getTheoreticalUnitCount());
            dto.setPreRequiredLectures(l.getPreRequiredLectures());
            dto.setCode(l.getCode());
            dtos.add(dto);
        }
        return dtos;
    }
}
