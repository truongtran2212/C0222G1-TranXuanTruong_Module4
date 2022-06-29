package com.codegym._11_spring_data_repository_json.service;


import com.codegym._11_spring_data_repository_json.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void create(String typeBlog);
}
