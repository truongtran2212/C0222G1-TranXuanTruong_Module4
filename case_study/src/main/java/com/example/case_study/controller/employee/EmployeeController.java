package com.example.case_study.controller.employee;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.User;
import com.example.case_study.model.employee.dto.EmployeeDto;
import com.example.case_study.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    // search và findAll chung 1 method
    @GetMapping("/list-employee")
    public String showListCustomer(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "name", defaultValue = "") String name,
                                   Model model) {
        model.addAttribute("employeeList", employeeService.findAll(PageRequest.of(page, 5), name));
        model.addAttribute("name", name);
        return "employee/index-employee";
    }

    @GetMapping("/create-employee")
    public String showCreateEmployee(Model model) {
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("user", new User());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create-employee";
    }

    @PostMapping("/create-employee")
    public String create(@Valid @ModelAttribute(name = "employeeDto") EmployeeDto employeeDto,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("positionList", positionService.findAll());

            return "employee/create-employee";
        }

        userService.create(employeeDto.getUser());
        employeeService.create(employeeDto);

        return "redirect:/list-employee";
    }

    @GetMapping("/{id}/delete-employee")
    public String showEmployeeDelete(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/delete-employee";
    }

    @PostMapping("/delete-employee")
    public String delete(Employee employee) {
        employeeService.delete(employee.getEmployeeId());
        return "redirect:/list-employee";
    }

    @GetMapping("/{id}/update-employee")
    public String showUpdateEmployee(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("userList", userService.findAll());

        Employee employee = employeeService.findById(id);

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getEmployeeBirthday(),
                employee.getEmployeeIdCard(),
                employee.getEmployeeSalary(),
                employee.getEmployeePhone(),
                employee.getEmployeeEmail(),
                employee.getEmployeeAddress(),
                employee.getPosition().getPositionId(),
                employee.getEducationDegree().getEducationDegreeId(),
                employee.getDivision().getDivisionId(),
                employee.getUser());
        model.addAttribute("employeeDto", employeeDto);
        return "employee/update-employee";
    }

    @PostMapping("/update-employee")
    public String update(@Valid @ModelAttribute(name = "employeeDto") EmployeeDto employeeDto,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("userList", userService.findAll());

            return "employee/update-employee";
        }

        employeeService.update(employeeDto.getEmployeeName(),
                employeeDto.getEmployeeBirthday(),
                employeeDto.getEmployeeIdCard(),
                employeeDto.getEmployeeSalary(),
                employeeDto.getEmployeePhone(),
                employeeDto.getEmployeeEmail(),
                employeeDto.getEmployeeAddress(),
                employeeDto.getPositionId(),
                employeeDto.getEducationDegreeId(),
                employeeDto.getDivisionId(),
                employeeDto.getUser().getUserName(),
                employeeDto.getId()
        );
        return "redirect:/list-employee";
    }
}