package com.example.case_study.service.employee.impl;

import com.example.case_study.model.employee.User;
import com.example.case_study.repository.employee.UserRepository;
import com.example.case_study.service.employee.EmployeeService;
import com.example.case_study.service.employee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void create(String userName, String password) {
        userRepository.create(userName, password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
