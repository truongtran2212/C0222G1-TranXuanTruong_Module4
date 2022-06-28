package com.codegym.demo.service.impl;

import com.codegym.demo.model.Student;
import com.codegym.demo.repository.IStudentRepository;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAllStudent();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return iStudentRepository.findAllStudent(pageable);
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Student findById(Integer codeStudent) {
        return iStudentRepository.findById(codeStudent).orElse(null);
    }
}
