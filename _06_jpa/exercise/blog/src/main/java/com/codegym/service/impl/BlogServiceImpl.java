package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.model.BlogDetail;
import com.codegym.repository.BlogDetailRepository;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogDetailRepository blogDetailRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAllBlog();
    }


    @Override
    public void create(String content) {
        blogDetailRepository.create(content);
    }

    @Override
    public void create(String title, String createDay) {
        blogRepository.create(title, createDay);
    }

    @Override
    public void delete(int id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(String title, String content, String createDay, int id) {
        blogRepository.update(title, content, createDay, id);
    }

    @Override
    public List<BlogDetail> findAllBlogDetail() {
        return blogDetailRepository.findAllBlogDetail();
    }
}
