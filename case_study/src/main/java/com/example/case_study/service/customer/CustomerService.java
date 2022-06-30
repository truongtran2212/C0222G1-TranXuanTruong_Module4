package com.example.case_study.service.customer;

import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll (Pageable pageable);

    void create (String customerCode,
                String customerName,
                 String customerBirthday,
                 int customerGender,
                 String customerIdCard,
                 String customerPhone,
                 String customerEmail,
                 String customerAddress,
                 int customerType);
    void delete(int id);

    Customer findById(int id);

    void update(String customerCode,
                String customerName,
                String customerBirthday,
                int customerGender,
                String customerIdCard,
                String customerPhone,
                String customerEmail,
                String customerAddress,
                int customerType,
                int id);

//    void update (Customer customer);

//    Page<Customer> findByName (String name,Pageable pageable);

    List<Customer> search (String name);
}
