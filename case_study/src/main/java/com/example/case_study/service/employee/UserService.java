package com.example.case_study.service.employee;

import com.example.case_study.model.employee.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    User create(User user);

    void create (String userName, String password);

    List<User> findAll();
}
