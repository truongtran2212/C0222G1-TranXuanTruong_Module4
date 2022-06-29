package com.codegym._11_spring_data_repository_json.service.impl;

import com.codegym._11_spring_data_repository_json.model.Category;
import com.codegym._11_spring_data_repository_json.repository.CategoryRepository;
import com.codegym._11_spring_data_repository_json.service.CategoryService;
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
