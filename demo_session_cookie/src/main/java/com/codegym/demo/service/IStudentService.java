package com.codegym.demo.service;

import com.codegym.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    Page<Student> getAll(Pageable pageable);

    void save(Student student);

    Student findById(Integer codeStudent);
}
