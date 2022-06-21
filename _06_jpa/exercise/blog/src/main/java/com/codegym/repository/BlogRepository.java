package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BlogRepository extends JpaRepository<Blog, Integer> {


    @Query(value = "select * from blog where status = 0", nativeQuery = true)
    List<Blog> findAllBlog();

    @Modifying
    @Query(value = "insert into blog (title,create_day) values (:title,:createDay)", nativeQuery = true)
    void create(@Param("title") String title,
                @Param("createDay") String createDay);

    @Modifying
    @Query(value = "update blog set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Modifying
    @Query(value = "update blog set title = :title,blog_detail_id = :content,create_day = :createDay where id = :id", nativeQuery = true)
    void update(@Param("title") String title,
                @Param("content") String content,
                @Param("createDay") String createDay,
                @Param("id") int id);


}
