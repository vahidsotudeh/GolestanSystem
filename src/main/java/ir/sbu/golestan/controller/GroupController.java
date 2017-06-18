package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.Group;
import ir.sbu.golestan.dto.GroupDTO;
import ir.sbu.golestan.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ali Asghar on 18/06/2017.
 */
@RestController
@RequestMapping("api/groups")
public class GroupController extends AbstractPagingAndSortingController{
    @Autowired
    public GroupController(GroupService service){
        super.s = service;
        super.eClass = Group.class;
        super.dClass = GroupDTO.class;
    }
}
