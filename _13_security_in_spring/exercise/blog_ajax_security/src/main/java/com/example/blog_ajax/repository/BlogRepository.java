package com.example.blog_ajax.repository;

import com.example.blog_ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Query(value = "insert into blog (title,create_day,blog_detail_id,id_category)" +
            " values (:title,:createDay,:blogDetailId,:idCategory)", nativeQuery = true)
    void create(@Param("title") String title,
                @Param("createDay") String createDay,
                @Param("blogDetailId") int blogDetailId,
                @Param("idCategory") int idCategory);

    @Modifying
    @Query(value = "update blog set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Modifying
    @Query(value = "update blog set title = :title,create_day = :createDay,id_category = :idCategory" +
            " where id = :id", nativeQuery = true)
    void update(@Param("title") String title,
                @Param("createDay") String createDay,
                @Param("idCategory") int idCategory,
                @Param("id") int id);

    @Query(value = "select * from blog where status = 0", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable);

    @Query(value = "select * from blog where title like %:title% and status = 0", nativeQuery = true)
    Page<Blog> search(@Param("title") String title, Pageable pageable);

    @Query(value = "select * from blog where title like %:title% and status = 0", nativeQuery = true)
    List<Blog> search(@Param("title") String title);

    @Query(value = "select * from blog where id_category = :idCategory and status = 0", nativeQuery = true)
    Page<Blog> searchCategory(@Param("idCategory") int idCategory, Pageable pageable);
}
