package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.dto.LectureFullDTO;
import ir.sbu.golestan.repository.LectureRepository;
import ir.sbu.golestan.service.LectureService;
import ir.sbu.golestan.util.PageHelper;
import ir.sbu.golestan.util.PageParams;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private ModelMapper modelMapper;

    @Autowired
    private PageHelper pageHelper;

    @Autowired
    private LectureService lectureService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<LectureFullDTO> getLectures(@RequestParam("start") Optional<String> start,
                                                          @RequestParam("size") Optional<String> size,
                                                          @RequestParam("sortBy") Optional<String> sortBy,
                                                          @RequestParam("sortDir") Optional<String> sortDir){
        PageParams pageParams = pageHelper.parse(start, size, sortBy, sortDir);
        List<Lecture> lectures = lectureService.getLectures(pageParams);
        return lectures.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    LectureFullDTO getLecture(@PathVariable("id") Long id){
        return convertToDto(lectureRepository.findOne(id));
    }


    @PreAuthorize("hasRole('GROUP_MANAGER')")
    @RequestMapping(value = "delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            lectureRepository.delete(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("lecture doesn't exists");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PreAuthorize("hasRole('GROUP_MANAGER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public ResponseEntity addLecture(@RequestBody LectureFullDTO dto){

        if(lectureRepository.findByName(dto.getName()) != null
                || lectureRepository.findByCode(dto.getCode()) != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("lecture already exists");

        lectureRepository.save(convertToEntity(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body("lecture created successfully");

    }

    @PreAuthorize("hasRole('GROUP_MANAGER')")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody LectureFullDTO dto){
        lectureRepository.save(convertToEntity(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private LectureFullDTO convertToDto(Lecture lecture) {
        return modelMapper.map(lecture, LectureFullDTO.class);
    }

    private Lecture convertToEntity(LectureFullDTO lectureFullDTO){
        return modelMapper.map(lectureFullDTO, Lecture.class);
    }
}
