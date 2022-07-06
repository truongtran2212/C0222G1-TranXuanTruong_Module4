package com.example.case_study.controller.contract;

import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.service.contract.ContractDetailService;
import com.example.case_study.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

    @GetMapping("/list-contract-detail")
    public String showListContract(@RequestParam(name = "page", defaultValue = "0") int page, Model model){
        model.addAttribute("contractDetailList",contractDetailService.findAll(PageRequest.of(page,5)));
        return "contract/index-contract-detail";
    }
}
