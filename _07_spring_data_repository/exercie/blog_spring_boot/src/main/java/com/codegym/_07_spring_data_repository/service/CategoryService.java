package com.codegym._07_spring_data_repository.service;


import com.codegym._07_spring_data_repository.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void create(String typeBlog);
}
