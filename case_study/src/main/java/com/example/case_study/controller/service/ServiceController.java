package com.example.case_study.controller.service;

import com.example.case_study.service.service.RentTypeService;
import com.example.case_study.service.service.ServiceService;
import com.example.case_study.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/list-service")
    public String showListService(@RequestParam(name = "page", defaultValue = "0") int page, Model model){
       model.addAttribute("serviceList", serviceService.findAll(PageRequest.of(page,5)));
       model.addAttribute("serviceTypeList", serviceTypeService.findAll());
       model.addAttribute("rentTypeList", rentTypeService.findAll());

       return "service/index-service";
    }
}
