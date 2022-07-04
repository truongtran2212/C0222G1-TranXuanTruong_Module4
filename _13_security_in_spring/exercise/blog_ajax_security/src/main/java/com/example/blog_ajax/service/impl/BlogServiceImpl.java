package com.example.blog_ajax.service.impl;

import com.example.blog_ajax.model.Blog;
import com.example.blog_ajax.repository.BlogRepository;
import com.example.blog_ajax.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAllBlog();
    }

    @Override
    public void create(String title, String createDay, int blogDetailId, int idCategory) {
        blogRepository.create(title, createDay, blogDetailId, idCategory);
    }

    @Override
    public Blog delete(int id) {
        blogRepository.delete(id);
        return null;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog update(String title, String createDay, int idCategory, int id) {
        blogRepository.update(title, createDay, idCategory, id);
        return null;
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAllBlog(pageable);
    }

    @Override
    public Page<Blog> search(String title, Pageable pageable) {
        return blogRepository.search(title, pageable);
    }

    @Override
    public List<Blog> search(String title) {
        return blogRepository.search(title);
    }

    @Override
    public Page<Blog> searchCategory(int idCategory, Pageable pageable) {
        return blogRepository.searchCategory(idCategory, pageable);
    }
}
