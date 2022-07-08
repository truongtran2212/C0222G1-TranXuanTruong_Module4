package com.example.case_study.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage(){
        return "home_page/home";
    }

    @GetMapping("")
    public String login(){
        return "redirect:/login";
    }
}
