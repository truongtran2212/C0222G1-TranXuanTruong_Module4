package com.example.case_study.controller.contract;

import com.example.case_study.model.contract.AttachService;
import com.example.case_study.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttachServiceController {
    @Autowired
    private AttachServiceService attachServiceService;

//    @GetMapping("/list-attach-service")
//    public String showListAttachService(Model model){
//        model.addAttribute("attachServiceList", attachServiceService.findAll());
//        return "contract/index-contract-detail";
//    }
}
