package ir.sbu.golestan.controller;

import ir.sbu.golestan.domain.User;
import ir.sbu.golestan.dto.UserDto;
import ir.sbu.golestan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ali Asghar on 18/05/2017.
 */
@Controller
@RequestMapping("/users")
public class UserController extends AbstractPagingAndSortingController<User, UserDto>{
    @Autowired
    public UserController(UserService userService){
        super.s = userService;
        super.eClass = User.class;
        super.dClass = UserDto.class;
    }
}
