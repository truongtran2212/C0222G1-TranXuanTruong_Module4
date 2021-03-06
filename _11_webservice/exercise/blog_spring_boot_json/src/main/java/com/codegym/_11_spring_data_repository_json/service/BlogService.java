package com.codegym._11_spring_data_repository_json.service;

import com.codegym._11_spring_data_repository_json.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void create(String title, String createDay, int blogDetailId, int idCategory);

    Blog delete(int id);

    Blog findById(int id);

    Blog update(String title, String createDay, int idCategory, int id);

    Page<Blog> findAllBlog(Pageable pageable);

    Page<Blog> search(String title, Pageable pageable);

    Page<Blog> searchCategory(int idCategory, Pageable pageable);
}