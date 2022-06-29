package com.codegym._11_spring_data_repository_json.service.impl;

import com.codegym._11_spring_data_repository_json.model.BlogDetail;
import com.codegym._11_spring_data_repository_json.repository.BlogDetailRepository;
import com.codegym._11_spring_data_repository_json.service.BlogDetailService;
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
