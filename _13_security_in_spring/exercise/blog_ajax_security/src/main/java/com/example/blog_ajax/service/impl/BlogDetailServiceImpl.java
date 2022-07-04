package com.example.blog_ajax.service.impl;

import com.example.blog_ajax.model.BlogDetail;
import com.example.blog_ajax.repository.BlogDetailRepository;
import com.example.blog_ajax.service.BlogDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogDetailServiceImpl implements BlogDetailService {

    @Autowired
    private BlogDetailRepository blogDetailRepository;

    @Override
    public void createDetail(String content) {
        blogDetailRepository.create(content);
    }


    @Override
    public List<BlogDetail> findAllBlogDetail() {
        return blogDetailRepository.findAllBlogDetail();
    }
}
