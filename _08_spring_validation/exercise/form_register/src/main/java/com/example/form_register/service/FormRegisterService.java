package com.example.form_register.service;

import com.example.form_register.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormRegisterService {
    Page<User> findAll(Pageable pageable);

    void create(String firstName, String lastName, String phoneNumber, int age, String email);
}
