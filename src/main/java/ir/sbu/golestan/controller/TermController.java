package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Lecture;
import ir.sbu.golestan.domain.Term;
import ir.sbu.golestan.dto.LectureFullDTO;
import ir.sbu.golestan.dto.TermDTO;
import ir.sbu.golestan.service.TermService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/terms")
public class TermController extends AbstractPagingAndSortingController<Term, TermDTO> {
    public TermController(TermService service){
        super.s = service;
        super.eClass = Term.class;
        super.dClass = TermDTO.class;
    }

    @GetMapping("/lectures")
    public ResponseEntity getLectures(Long termId){
        if(securityHelper.hasReadPermission(Lecture.class.getSimpleName())
                &&securityHelper.hasReadPermission(Term.class.getSimpleName())) {
            Term t = s.get(termId);
            return ResponseEntity.ok(modelMapper.map(t.getLectures(), LectureFullDTO.class));
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("you don't have permission");
    }
}
