package com.example.case_study.controller.contract;

import com.example.case_study.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping("/list-contract")
    public String showListContract(@RequestParam(name = "page", defaultValue = "0") int page, Model model){
        model.addAttribute("contractList",contractService.findAll(PageRequest.of(page,5)));
        return "contract/index-contract";
    }

}
