package com.example.golestan;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Microsoft on 15/05/2017.
 */
@Controller
public class HelloWorldController  {
    @RequestMapping("/test")
    public String hello(Model model){
        model.addAttribute("hi","aaa");
        return "index";
    }
}
