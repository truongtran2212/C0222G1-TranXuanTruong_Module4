package com.codegym._07_spring_data_repository.service;

import com.codegym._07_spring_data_repository.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void create(String title, String createDay, int blogDetailId, int idCategory);

    void delete(int id);

    Blog findById(int id);

    void update(String title, String createDay, int idCategory, int id);

    Page<Blog> findAllBlog(Pageable pageable);

    List<Blog> search(String title);
}