package com.example.case_study.controller.employee;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.User;
import com.example.case_study.model.employee.dto.EmployeeDto;
import com.example.case_study.service.employee.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/list-employee")
    public String showListCustomer(@RequestParam(name = "page", defaultValue = "0") int page, Model model){
        model.addAttribute("employeeList", employeeService.findAll(PageRequest.of(page,5)));
        return "employee/index-employee";
    }

    @GetMapping("/create-employee")
    public String showCreateEmployee(Model model){
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("user", new User());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create-employee";
    }

    @PostMapping("/create-employee")
    public String create(@ModelAttribute(name = "employeeDto") EmployeeDto employeeDto){

        userService.create(employeeDto.getUser());
        employeeService.create(employeeDto);

        return "redirect:/list-employee";
    }

    @GetMapping("/{id}/delete-employee")
    public String showEmployeeDelete(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/delete-employee";
    }
    @PostMapping("/delete-employee")
    public String delete(Employee employee){
        employeeService.delete(employee.getEmployeeId());
        return "redirect:/list-employee";
    }

    @GetMapping("/{id}/update-employee")
    public String showUpdateEmployee(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/update-employee";
    }

    @PostMapping("/update-employee")
    public String update(@ModelAttribute(name = "employee") Employee employee){
        employeeService.update(employee.getEmployeeName(),
                employee.getEmployeeBirthday(),
                employee.getEmployeeIdCard(),
                employee.getEmployeeSalary(),
                employee.getEmployeePhone(),
                employee.getEmployeeEmail(),
                employee.getEmployeeAddress(),
                employee.getPosition().getPositionId(),
                employee.getEducationDegree().getEducationDegreeId(),
                employee.getDivision().getDivisionId(),
                employee.getUser().getUserName(),
                employee.getEmployeeId()
        );

        return "redirect:/list-employee";
    }

    @GetMapping("/search-employee")
    public String search(String nameEmployee, Model model){
        model.addAttribute("employeeList", employeeService.search(nameEmployee));
        return "employee/search-employee";
    }

}
