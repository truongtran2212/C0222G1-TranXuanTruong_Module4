package com.example.case_study.controller.employee.rest_controller;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.User;
import com.example.case_study.model.employee.dto.EmployeeDto;
import com.example.case_study.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @GetMapping("/list-employee-ajax")
    public ResponseEntity<?> showListCustomer(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                @RequestParam(name = "name", defaultValue = "") String name) {

        return new ResponseEntity<>(employeeService.findAll(PageRequest.of(page,5),name), HttpStatus.OK);
    }

    @PostMapping("/create-employee")
    public ResponseEntity<?> create(@RequestBody EmployeeDto employeeDto) {

        return new ResponseEntity<>(employeeService.create(employeeDto),userService.create(employeeDto.getUser()),HttpStatus.CREATED);
    }
}
