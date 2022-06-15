package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandWichController {

    @GetMapping
    public String showList(){
        return "list";
    }

    @PostMapping("/save")
    public String spices(@RequestParam("spices") String[] spices, Model model){

        model.addAttribute("result", Arrays.toString(spices));
        return "list";
    }
}
