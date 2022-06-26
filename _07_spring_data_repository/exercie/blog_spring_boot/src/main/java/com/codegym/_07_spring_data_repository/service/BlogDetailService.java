package com.codegym._07_spring_data_repository.service;

import com.codegym._07_spring_data_repository.model.BlogDetail;

import java.util.List;

public interface BlogDetailService {
    List<BlogDetail> findAllBlogDetail();

    void createDetail(String content);
}
