package com.example.case_study.service.employee.impl;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.dto.EmployeeDto;
import com.example.case_study.repository.employee.EmployeeRepository;
import com.example.case_study.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void create(EmployeeDto employeeDto) {
        employeeRepository.create(  employeeDto.getEmployeeName(),
                employeeDto.getEmployeeBirthday(),
                employeeDto.getEmployeeIdCard(),
                employeeDto.getEmployeeSalary(),
                employeeDto.getEmployeePhone(),
                employeeDto.getEmployeeEmail(),
                employeeDto.getEmployeeAddress(),
                employeeDto.getPositionId(),
                employeeDto.getEducationDegreeId(),
                employeeDto.getDivisionId(),
                employeeDto.getUser().getUserName());
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee findById(int id) {
      return   employeeRepository.findById(id);
    }

    @Override
    public void update(String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary,
                       String employeePhone, String employeeEmail, String employeeAddress, int positionId,
                       int educationDegreeId, int divisionId, String userName, int id) {
        employeeRepository.update(employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName, id);
    }

    @Override
    public List<Employee> search(String employeeName) {
        return employeeRepository.search(employeeName);
    }
}
