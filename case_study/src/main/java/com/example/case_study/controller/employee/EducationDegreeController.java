package com.example.case_study.controller.employee;

import com.example.case_study.service.employee.DivisionService;
import com.example.case_study.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EducationDegreeController {
    @Autowired
    private EducationDegreeService educationDegreeService;

//    @GetMapping("/create-customer")
//    public String listEducationDegree(Model model){
//        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//        return "employee/create-employee";
//    }
}