package com.example.case_study.controller.service;

import com.example.case_study.model.service.Service;
import com.example.case_study.model.service.dto.ServiceDto;
import com.example.case_study.service.service.RentTypeService;
import com.example.case_study.service.service.ServiceService;
import com.example.case_study.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/list-service")
    public String showListService(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("serviceList", serviceService.findAll(PageRequest.of(page, 5)));
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "service/index-service";
    }

    @GetMapping("/create-service/{name}")
    public String showFormCreate(@PathVariable(name = "name") String nameService, Model model) {
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("name", nameService);
        return "service/create-service";
    }

    @PostMapping("/create-service")
    public String create(@Valid @ModelAttribute(name = "serviceDto") ServiceDto serviceDto, BindingResult bindingResult,
                         Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            model.addAttribute("name" , serviceDto.getServiceType().getServiceTypeName());
            return "service/create-service";
        }
        serviceService.create(serviceDto);
        return "redirect:/list-service";
    }

    @GetMapping("/{id}/update-service")
    public String showFormUpdate(@PathVariable int id, Model model){
        Service service = serviceService.findById(id);
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        ServiceDto serviceDto = new ServiceDto( service.getServiceId(),
                                                service.getServiceCode(),
                                                service.getServiceName(),
                                                service.getServiceArea(),
                                                service.getServiceCost(),
                                                service.getServiceMaxPeople(),
                                                service.getStandardRoom(),
                                                service.getDescriptionOtherConvenience(),
                                                service.getPoolArea(),
                                                service.getNumberOfFloors(),
                                                service.getRentType(),
                                                service.getServiceType());

        model.addAttribute("serviceDto", serviceDto);
        return "service/update-service";
    }

    @PostMapping("/update-service")
    public String update (@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "service/update-service";
        }

        serviceService.update(serviceDto);
        return "redirect:/list-service";
    }
}
