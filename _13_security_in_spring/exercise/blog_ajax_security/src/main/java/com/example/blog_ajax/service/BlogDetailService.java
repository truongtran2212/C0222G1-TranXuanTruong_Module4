package com.example.blog_ajax.service;

import com.example.blog_ajax.model.BlogDetail;

import java.util.List;

public interface BlogDetailService {
    List<BlogDetail> findAllBlogDetail();

    void createDetail(String content);
}
