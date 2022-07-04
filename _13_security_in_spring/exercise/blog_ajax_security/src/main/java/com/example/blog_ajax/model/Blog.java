package com.example.blog_ajax.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Column(name = "create_day")
    private String createDay;
    @ColumnDefault("0")
    private int status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_detail_id", referencedColumnName = "id")
    @JsonBackReference(value = "blog_detail")
    private BlogDetail blogDetail;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id")
//    @JsonBackReference(value = "category")
    private Category category;

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(Integer id, String title, String createDay, int status, BlogDetail blogDetail, Category category) {
        this.id = id;
        this.title = title;
        this.createDay = createDay;
        this.status = status;
        this.blogDetail = blogDetail;
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String title, String createDay, int status) {
        this.id = id;
        this.title = title;
        this.createDay = createDay;
        this.status = status;
    }

    public Blog(String title, String createDay, int status) {
        this.title = title;
        this.createDay = createDay;
        this.status = status;
    }

    public Blog(int id, String title, String createDay, int status, BlogDetail blogDetail) {
        this.id = id;
        this.title = title;
        this.createDay = createDay;
        this.status = status;
        this.blogDetail = blogDetail;
    }

    public BlogDetail getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(BlogDetail blogDetail) {
        this.blogDetail = blogDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
