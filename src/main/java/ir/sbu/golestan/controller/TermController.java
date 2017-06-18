package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Term;
import ir.sbu.golestan.dto.TermDTO;
import ir.sbu.golestan.service.TermService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/terms")
public class TermController extends AbstractPagingAndSortingController {
    public TermController(TermService service){
        super.s = service;
        super.eClass = Term.class;
        super.dClass = TermDTO.class;
    }
}
