package com.example.case_study.controller.customer;

import com.example.case_study.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;



}
