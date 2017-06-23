package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Master;
import ir.sbu.golestan.dto.MasterFullDTO;
import ir.sbu.golestan.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/maters")
public class MasterController extends AbstractPagingAndSortingController {

    @Autowired
    public MasterController(MasterService service){
        super.s = service;
        super.eClass = Master.class;
        super.dClass = MasterFullDTO.class;
    }
}
