package ir.sbu.golestan.api;

import ir.sbu.golestan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ali Asghar on 18/05/2017.
 */
@Controller
@RequestMapping("/user")
public class UserApi{
    @Autowired
    private UserDao userDao;
}
