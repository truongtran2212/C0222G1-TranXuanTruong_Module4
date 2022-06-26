package com.example.case_study.controller.employee;

import com.example.case_study.service.employee.DivisionService;
import com.example.case_study.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DivisionController {
    @Autowired
    private DivisionService divisionService;

//    @GetMapping("/create-customer")
//    public String listDivision(Model model){
//        model.addAttribute("divisionList", divisionService.findAll());
//        return "employee/create-employee";
//    }
}