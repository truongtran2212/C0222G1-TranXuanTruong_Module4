package com.example.blog_ajax.repository;

import com.example.blog_ajax.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category", nativeQuery = true)
    List<Category> findAll();

    @Modifying
    @Query(value = "insert into category (type_blog) values (:typeBlog)", nativeQuery = true)
    void create(@Param("typeBlog") String typeBlog);
}
