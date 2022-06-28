package com.codegym.demo.service.impl;

import com.codegym.demo.model.Classroom;
import com.codegym.demo.repository.IClassroomRepository;
import com.codegym.demo.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository iClassroomRepository;
    @Override
    public List<Classroom> findAll() {
        return iClassroomRepository.findAll();
    }
}
