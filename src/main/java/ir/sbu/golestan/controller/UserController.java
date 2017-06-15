package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.User;
import ir.sbu.golestan.dto.UserDto;
import ir.sbu.golestan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Ali Asghar on 18/05/2017.
 */
@Controller
@RequestMapping("api/users")
public class UserController extends AbstractPagingAndSortingController<User, UserDto>{
    @Autowired
    public UserController(UserService userService){
        super.s = userService;
        super.eClass = User.class;
        super.dClass = UserDto.class;
    }

    @RequestMapping("roles")
    public ResponseEntity getRoles(){
        Principal p = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return null;
    }
}
