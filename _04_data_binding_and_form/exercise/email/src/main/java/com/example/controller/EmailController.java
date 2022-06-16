package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping
    public String showEmail(Model model) {

        model.addAttribute("email", new Email());
        String[] language = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        int[] size = new int[]{5, 10, 15, 25, 50, 100};

        model.addAttribute("language", language);
        model.addAttribute("size", size);
        return "email";
    }

    @PostMapping("/show-email")
    public String email(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("email", email);

        return "show-email";
    }
}
