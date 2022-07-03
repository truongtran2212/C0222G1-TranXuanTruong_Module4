package com.example.case_study.service.customer.impl;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.repository.customer.CustomerRepository;
import com.example.case_study.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable, String name) {
        return customerRepository.findAll(pageable, name);
    }

    @Override
    public void create(String customerCode,
                       String customerName,
                       String customerBirthday,
                       int customerGender,
                       String customerIdCard,
                       String customerPhone,
                       String customerEmail,
                       String customerAddress,
                       int customerType) {
        customerRepository.create(customerCode,
                customerName, customerBirthday,
                customerGender, customerIdCard,
                customerPhone, customerEmail,
                customerAddress, customerType);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(String customerCode, String customerName, String customerBirthday, int customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, int customerType, int id) {
        customerRepository.update(customerCode, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerType, id);
    }
}
