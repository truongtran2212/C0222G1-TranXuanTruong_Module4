package com.example.case_study.repository.employee;


import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    @Query(value = "select * from employee where status = 0 and employee_name like %:name%", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable, @Param("name") String name);


    @Modifying
    @Query(value = "insert into employee (employee_name,employee_birthday," +
            "employee_id_card,employee_salary,employee_phone,employee_email,employee_address," +
            "position_id,education_degree_id,division_id,username) values " +
            "(:employeeName,:employeeBirthday,:employeeIdCard,:employeeSalary,:employeePhone,:employeeEmail," +
            ":employeeAddress,:positionId,:educationDegreeId,:divisionId,:userName)", nativeQuery = true)
    void create(        @Param("employeeName") String employeeName,
                       @Param("employeeBirthday") String employeeBirthday,
                       @Param("employeeIdCard") String employeeIdCard,
                       @Param("employeeSalary") double employeeSalary,
                       @Param("employeePhone") String employeePhone,
                       @Param("employeeEmail") String employeeEmail,
                       @Param("employeeAddress") String employeeAddress,
                       @Param("positionId") int positionId,
                       @Param("educationDegreeId") int educationDegreeId,
                       @Param("divisionId") int divisionId,
                       @Param("userName") String userName
    );

    @Modifying
    @Query(value = "update employee set status = 1 where employee_id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from employee where employee_id = :id", nativeQuery = true)
    Employee findById(@Param("id") int id);

    @Modifying
    @Query(value = "update employee set employee_name = :employeeName,employee_birthday = :employeeBirthday," +
            "employee_id_card = :employeeIdCard,employee_salary = :employeeSalary,employee_phone = :employeePhone," +
            "employee_email = :employeeEmail,employee_address = :employeeAddress,position_id = :positionId," +
            "education_degree_id = :educationDegreeId,division_id = :divisionId,username = :userName where employee_id = :id",
            nativeQuery = true)
    void update(@Param("employeeName") String employeeName,
                @Param("employeeBirthday") String employeeBirthday,
                @Param("employeeIdCard") String employeeIdCard,
                @Param("employeeSalary") double employeeSalary,
                @Param("employeePhone") String employeePhone,
                @Param("employeeEmail") String employeeEmail,
                @Param("employeeAddress") String employeeAddress,
                @Param("positionId") int positionId,
                @Param("educationDegreeId") int educationDegreeId,
                @Param("divisionId") int divisionId,
                @Param("userName") String userName,
                @Param("id") int id);
}
