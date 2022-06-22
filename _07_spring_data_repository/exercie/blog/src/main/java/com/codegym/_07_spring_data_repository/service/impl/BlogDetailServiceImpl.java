package com.codegym._07_spring_data_repository.service.impl;

import com.codegym._07_spring_data_repository.model.BlogDetail;
import com.codegym._07_spring_data_repository.repository.BlogDetailRepository;
import com.codegym._07_spring_data_repository.service.BlogDetailService;
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
