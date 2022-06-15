package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String showList(){
        return "list";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("firstNumber") double firstNumber,
                             @RequestParam("secondNumber") double secondNumber,
                             @RequestParam("check") char check,
                             Model model){

        model.addAttribute("result", calculatorService.calculator(firstNumber, secondNumber,check));
        model.addAttribute("firstNumber",firstNumber );
        model.addAttribute("secondNumber",secondNumber );

        return "list";
    }
}
