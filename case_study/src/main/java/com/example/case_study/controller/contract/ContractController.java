package com.example.case_study.controller.contract;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.service.contract.AttachServiceService;
import com.example.case_study.service.contract.ContractDetailService;
import com.example.case_study.service.contract.ContractService;
import com.example.case_study.service.customer.CustomerService;
import com.example.case_study.service.employee.EmployeeService;
import com.example.case_study.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private AttachServiceService attachServiceService;

    @Autowired
    private ContractDetailService contractDetailService;

    @GetMapping("/list-contract")
    public String showListContract(@RequestParam(name = "page", defaultValue = "0") int page, Contract contract, Model model) {
        model.addAttribute("contractList", contractService.findAll(PageRequest.of(page, 5)));
        model.addAttribute("attachServiceList", attachServiceService.findAll());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
//        ContractDetail contractDetail = contractDetailService.findById(contract.getContractId());
        Double total = contractService.total();
        model.addAttribute("total", total);
        return "contract/index-contract";
    }

    @GetMapping("/create-contract")
    public String showFormCreate(Model model) {
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", serviceService.findAll());
        model.addAttribute("contract", new Contract());

        return "contract/create-contract";
    }

    @PostMapping("/create-contract")
    public String create(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, Model model) {
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("serviceList", serviceService.findAll());

            return "contract/create-contract";
        }

        contractService.create(contract);
        return "redirect:/list-contract";
    }
}
