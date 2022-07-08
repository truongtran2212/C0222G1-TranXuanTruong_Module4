package com.example.case_study.controller.employee.rest_controller;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.dto.EmployeeDto;
import com.example.case_study.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @GetMapping("/list-employee-ajax")
    public ResponseEntity<?> showListCustomer(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                @RequestParam(name = "name", defaultValue = "") String name) {

        return new ResponseEntity<>(employeeService.findAll(PageRequest.of(page,5),name).getContent(), HttpStatus.OK);
    }

    // @Valid phải đặt trc @RequestBody
    @PostMapping("/create-employee")
    public ResponseEntity<?> createEmployee( @RequestParam(name = "page", defaultValue = "0") int page,
                                             @Valid @RequestBody EmployeeDto employeeDto,
                                            @RequestParam(name = "name", defaultValue = "") String name) {

        // Phải tạo User trc nếu kh muốn bị lỗi
        userService.create(employeeDto.getUserApp());
        employeeService.create(employeeDto);
        List<Employee> employeeList = employeeService.findAll(PageRequest.of(page,5),name).getContent();
        return new ResponseEntity<>(employeeList,HttpStatus.CREATED);
    }

    @GetMapping("/update-employee/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
                employee.getUserApp());
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PutMapping("/update-employee")
    public ResponseEntity<?> update(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "name", defaultValue = "") String name,
                                    @RequestBody EmployeeDto employeeDto){
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
                employeeDto.getUserApp().getUserName(),
                employeeDto.getId()
        );

        List<Employee> employeeList = employeeService.findAll(PageRequest.of(page,5),name).getContent();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
