package com.example.case_study.controller.employee;


import com.example.case_study.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;

//    @GetMapping("/create-customer")
//    public String listPosition(Model model){
//        model.addAttribute("positionList", positionService.findAll());
//        return "employee/create-employee";
//    }
}
