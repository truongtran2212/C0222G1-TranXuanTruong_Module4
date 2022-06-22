package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.BlogDetail;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void create(String title, String createDay, int blogDetailId);

    void delete(int id);

    Blog findById(int id);

    void update(String title, String content, String createDay, int id);

    List<BlogDetail> findAllBlogDetail();

    void createDetail(String content);
}