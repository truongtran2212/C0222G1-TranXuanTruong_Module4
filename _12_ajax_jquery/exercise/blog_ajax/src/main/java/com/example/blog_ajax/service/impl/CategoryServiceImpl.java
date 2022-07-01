package com.example.blog_ajax.service.impl;

import com.example.blog_ajax.model.Category;
import com.example.blog_ajax.repository.CategoryRepository;
import com.example.blog_ajax.service.CategoryService;
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
