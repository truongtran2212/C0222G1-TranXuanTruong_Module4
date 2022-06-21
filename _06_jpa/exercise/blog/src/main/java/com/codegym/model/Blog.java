package com.codegym.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @Column(name = "create_day")
    private String createDay;
    @ColumnDefault("0")
    private int status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private BlogDetail blogDetail;

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
