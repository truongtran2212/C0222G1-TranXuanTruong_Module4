package com.codegym._07_spring_data_repository.service.impl;

import com.codegym._07_spring_data_repository.model.Category;
import com.codegym._07_spring_data_repository.repository.CategoryRepository;
import com.codegym._07_spring_data_repository.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void create(String typeBlog) {
        categoryRepository.create(typeBlog);
    }
}
