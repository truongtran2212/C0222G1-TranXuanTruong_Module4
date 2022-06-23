package com.example.form_register.service.impl;

import com.example.form_register.model.User;
import com.example.form_register.repository.FormRegisterRepository;
import com.example.form_register.service.FormRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FormRegisterServiceImpl implements FormRegisterService {
    @Autowired
    private FormRegisterRepository formRegisterRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return formRegisterRepository.findAll(pageable);
    }

    @Override
    public void create(String firstName, String lastName, String phoneNumber, int age, String email) {
        formRegisterRepository.create(firstName,lastName,phoneNumber,age,email);
    }
}
