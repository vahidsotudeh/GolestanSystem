package ir.sbu.golestan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Ali Asghar on 21/05/2017.
 */

@Controller
public class MainController {
    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    @GetMapping("/login")
    public String getLoginPage() {
        SecurityContextHolder.getContext().getAuthentication();
        if (authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
            return "/login";
        }
        return "redirect:/";
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
