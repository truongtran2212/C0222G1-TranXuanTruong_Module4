package com.codegym.demo.service;

import com.codegym.demo.model.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
}
