package com.example.case_study.controller.customer;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.dto.CustomerDto;
import com.example.case_study.service.customer.CustomerService;
import com.example.case_study.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    // search và findAll chung 1 method
    @GetMapping("/list-customer")
    public String showListCustomer(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "name", defaultValue = "") String name,
                                   Model model) {
        model.addAttribute("customerList", customerService.findAll(PageRequest.of(page, 5), name));
        model.addAttribute("name", name);
        return "customer/index-customer";
    }

    @GetMapping("/create-customer")
    public String showFormCreate(Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create-customer";
    }

    @PostMapping("/create-customer")
    public String create(@Valid @ModelAttribute(name = "customerDto") CustomerDto customerDto,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create-customer";
        }

        customerService.create(customerDto.getCustomerCode(), customerDto.getCustomerName(),
                customerDto.getCustomerBirthday(), customerDto.getCustomerGender(),
                customerDto.getCustomerIdCard(), customerDto.getCustomerPhone(), customerDto.getCustomerEmail(),
                customerDto.getCustomerAddress(), customerDto.getCustomerTypeId().getCustomerTypeId());
        return "redirect:/list-customer";
    }

    @GetMapping("/delete-customer/{id}")
    public String showFormDelete(@RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "name", defaultValue = "") String name,
                                 @PathVariable int id, Model model) {
        customerService.delete(id);
        model.addAttribute("customerList", customerService.findAll(PageRequest.of(page, 5), name));
        return "customer/index-customer";
    }

    @GetMapping("/{id}/update-customer")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());

        Customer customer = customerService.findById(id);

        CustomerDto customerDto = new CustomerDto(customer.getCustomerId(),
                customer.getCustomerCode(),
                customer.getCustomerName(),
                customer.getCustomerBirthday(),
                customer.getCustomerGender(),
                customer.getCustomerIdCard(),
                customer.getCustomerPhone(),
                customer.getCustomerEmail(),
                customer.getCustomerAddress(),
                customer.getCustomerType());

        model.addAttribute("customerDto", customerDto);
        return "customer/update-customer";
    }

    @PostMapping("update-customer")
    public String update(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/update-customer";
        }

        customerService.update(customerDto.getCustomerCode(),
                customerDto.getCustomerName(),
                customerDto.getCustomerBirthday(),
                customerDto.getCustomerGender(),
                customerDto.getCustomerIdCard(),
                customerDto.getCustomerPhone(),
                customerDto.getCustomerEmail(),
                customerDto.getCustomerAddress(),
                customerDto.getCustomerTypeId().getCustomerTypeId(),
                customerDto.getId());
        return "redirect:/list-customer";
    }
}
