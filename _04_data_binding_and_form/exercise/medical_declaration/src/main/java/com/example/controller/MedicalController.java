package com.example.controller;

import com.example.model.Medical;
import com.example.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @Autowired
    private MedicalService medicalService;

    @GetMapping
    String showDeclaration(Model model) {

        model.addAttribute("medical", new Medical());
        model.addAttribute("year", medicalService.year());
        model.addAttribute("gender", medicalService.gender());
        model.addAttribute("nationality", medicalService.nationality());

        return "form";
    }

    @PostMapping("/information")
    String information(@ModelAttribute("medical") Medical medical, Model model) {
        model.addAttribute("medical", medical);

        return "information";

    }
}
