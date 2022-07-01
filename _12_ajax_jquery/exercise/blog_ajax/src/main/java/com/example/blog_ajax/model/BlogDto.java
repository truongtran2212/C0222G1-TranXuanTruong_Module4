package com.example.blog_ajax.model;

public class BlogDto {
    private String title;
    private String content;
    private String createDay;
    private int idCategory;

    public BlogDto() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public BlogDto(String title, String content, String createDay, int idCategory) {
        this.title = title;
        this.content = content;
        this.createDay = createDay;
        this.idCategory = idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public BlogDto(String title, String content, String createDay) {
        this.title = title;
        this.content = content;
        this.createDay = createDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }
}
