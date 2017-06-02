package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.SubGroup;
import ir.sbu.golestan.dto.LectureDTO;
import ir.sbu.golestan.dto.PreRequiredLectureDTO;
import ir.sbu.golestan.repository.LectureRepository;
import ir.sbu.golestan.repository.SubGroupRepository;
import jersey.repackaged.com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Ali Asghar on 28/05/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private SubGroupRepository subGroupRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    @RequestMapping(value = "delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            lectureRepository.delete(id);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public ResponseEntity addLecture(@RequestBody LectureDTO dto){
        if(lectureRepository.findByName(dto.getName()) != null
                || lectureRepository.findByCode(dto.getCode()) != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Lecture lecture = new Lecture();
        lecture.setName(dto.getName());
        lecture.setCode(dto.getCode());
        lecture.setTheoreticalUnitCount(dto.getTheoreticalUnitCount());
        lecture.setPracticalUnitCount(dto.getPracticalUnitCount());

        Set<SubGroup> subGroups = new HashSet<>();

        for(SubGroup sb: dto.getSubGroups()){
            SubGroup nsb = subGroupRepository.findOne(sb.getId());
            if(nsb == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            subGroups.add(nsb);
        }

        lecture.setSubGroups(subGroups);

        Set<Lecture> preLectures = new HashSet<>();

        for(PreRequiredLectureDTO prl: dto.getPreRequiredLectures()){
            Lecture l = lectureRepository.findOne(prl.getId());
            if(l == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            preLectures.add(l);
        }

        lecture.setPreRequiredLectures(preLectures);

        lectureRepository.save(lecture);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody LectureDTO dto){
        Lecture old = lectureRepository.findOne(dto.getId());
        Lecture newLec = updateLecture(dto, old);
        lectureRepository.save(old);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Lecture getLecture(LectureDTO dto){
        Lecture l = new Lecture();
        l.setName(dto.getName());
        l.setId(dto.getId());
        l.setCode(dto.getCode());
        l.setPracticalUnitCount(dto.getPracticalUnitCount());
        l.setTheoreticalUnitCount(dto.getTheoreticalUnitCount());
        Set<SubGroup> subGroups = new HashSet<>();
        for(SubGroup sg: dto.getSubGroups()){
            SubGroup subGroup = subGroupRepository.findOne(sg.getId());
            subGroups.add(subGroup);
        }
        Set<Lecture> preLectures = new HashSet<>();

        for(PreRequiredLectureDTO prldto: dto.getPreRequiredLectures()){
            Lecture lecture = lectureRepository.findOne(prldto.getId());
            preLectures.add(lecture);
        }
        l.setSubGroups(subGroups);
        l.setPreRequiredLectures(preLectures);
        return l;
    }

    public Lecture updateLecture(LectureDTO dto, Lecture old){
        old.setName(dto.getName());
        old.setId(dto.getId());
        old.setCode(dto.getCode());
        old.setPracticalUnitCount(dto.getPracticalUnitCount());
        old.setTheoreticalUnitCount(dto.getTheoreticalUnitCount());
        Set<SubGroup> subGroups = new HashSet<>();
        for(SubGroup sg: dto.getSubGroups()){
            SubGroup subGroup = subGroupRepository.findOne(sg.getId());
            subGroups.add(subGroup);
        }
        Set<Lecture> preLectures = new HashSet<>();

        for(PreRequiredLectureDTO prldto: dto.getPreRequiredLectures()){
            Lecture lecture = lectureRepository.findOne(prldto.getId());
            preLectures.add(lecture);
        }
        old.setSubGroups(subGroups);
        old.setPreRequiredLectures(preLectures);
        return old;
    }
}
