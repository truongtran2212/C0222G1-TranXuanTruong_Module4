package com.example.blog_ajax.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_blog")
    private String typeBlog;

    @OneToMany(mappedBy = "category")
    @JsonBackReference(value = "loop")
    private Set<Blog> blog;

    public Category() {
    }

    public Category(Integer id, String typeBlog, Set<Blog> blog) {
        this.id = id;
        this.typeBlog = typeBlog;
        this.blog = blog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(String typeBlog) {
        this.typeBlog = typeBlog;
    }

    public Set<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Set<Blog> blog) {
        this.blog = blog;
    }
}
