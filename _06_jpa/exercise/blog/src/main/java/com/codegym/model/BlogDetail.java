package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog_detail")
public class BlogDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content", columnDefinition = "text")
    private String content;

    @OneToOne(mappedBy = "blogDetail")
    private Blog blog;

    public BlogDetail() {
    }

    public BlogDetail(int id, String content, Blog blog) {
        this.id = id;
        this.content = content;
        this.blog = blog;
    }

    public BlogDetail(String content, Blog blog) {
        this.content = content;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
