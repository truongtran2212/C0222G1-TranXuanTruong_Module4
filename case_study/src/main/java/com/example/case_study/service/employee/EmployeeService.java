package com.example.case_study.service.employee;

import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeService {
   Page<Employee> findAll (Pageable pageable);

   void save (Employee employee);

   void create (EmployeeDto employeeDto);

   void delete (int id);

   Employee findById(int id);

   void update(String employeeName,
               String employeeBirthday,
               String employeeIdCard,
               double employeeSalary,
               String employeePhone,
               String employeeEmail,
               String employeeAddress,
               int positionId,
               int educationDegreeId,
               int divisionId,
               String userName,
               int id);

   List<Employee> search(String employeeName);
}
