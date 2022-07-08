package com.example.case_study.service.employee;

import com.example.case_study.model.employee.UserApp;

import java.util.List;

public interface UserService {
    UserApp create(UserApp userApp);

    void create (String userName, String password);

    List<UserApp> findAll();
}
