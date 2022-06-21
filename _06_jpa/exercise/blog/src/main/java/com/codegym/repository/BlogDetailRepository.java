package com.codegym.repository;

import com.codegym.model.BlogDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BlogDetailRepository {

    @Query(value = "select * from blog_detail", nativeQuery = true)
    List<BlogDetail> findAllBlogDetail ();

    @Modifying
    @Query(value = "insert into blog_detail (content) values (:content) ", nativeQuery = true)
    void create (@Param("content") String content);
}
