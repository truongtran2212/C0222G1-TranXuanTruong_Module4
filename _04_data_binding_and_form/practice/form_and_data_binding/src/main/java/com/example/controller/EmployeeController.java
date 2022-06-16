package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @GetMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/addEmployee")
    public String create (@ModelAttribute("employee") Employee employee, Model model){
        model.addAttribute("employee", employee);
        return "info";
    }
}
