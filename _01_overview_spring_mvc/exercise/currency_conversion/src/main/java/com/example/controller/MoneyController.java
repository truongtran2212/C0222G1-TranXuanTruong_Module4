package com.example.controller;

import com.example.service.CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @Autowired
    private CurrentService currentService;
    @GetMapping("/current")
    public String showList() {
        return "list";
    }
    @PostMapping("/current")
    public String current(@RequestParam(name = "USD") String usd, Model model){

        model.addAttribute("result",currentService.current(usd));
        model.addAttribute("usd",usd);
        return "list";
    }
}
