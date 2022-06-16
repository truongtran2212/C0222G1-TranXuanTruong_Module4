package com.example.controller;

import com.example.model.Login;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String home(Model model) {
        model.addAttribute("login", new Login());
        return "home";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model){
        User user = userService.checkLogin(login);
        if(user == null){
            return "error";
        } else {
            model.addAttribute("user", user);
            return "login";
        }
    }
}
