package ir.sbu.golestan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Ali Asghar on 21/05/2017.
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String home1() {
        return "login";
    }

//    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
//    public String login() {
//        return "login";
//    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}
