package com.example.blog_ajax.model;

public class BlogDtoNew {
    private int id;
    private String title;
    private String createDay;
    private String typeBlog;

    public BlogDtoNew() {
    }

    public BlogDtoNew(int id, String title, String createDay, String typeBlog) {
        this.id = id;
        this.title = title;
        this.createDay = createDay;
        this.typeBlog = typeBlog;
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

    public String getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(String typeBlog) {
        this.typeBlog = typeBlog;
    }
}
