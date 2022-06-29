package com.codegym._11_spring_data_repository_json.service;

import com.codegym._11_spring_data_repository_json.model.BlogDetail;

import java.util.List;

public interface BlogDetailService {
    List<BlogDetail> findAllBlogDetail();

    void createDetail(String content);
}
