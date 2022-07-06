package com.example.case_study.model.employee;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "username", unique = true)

    @NotBlank(message = "Không được đê trống")
    private String userName;

    @NotBlank(message = "Không được đê trống")
    private String password;

    @OneToOne(mappedBy = "user")
    @JsonBackReference(value = "user")

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User(String userName, String password, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.employee = employee;
    }

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
