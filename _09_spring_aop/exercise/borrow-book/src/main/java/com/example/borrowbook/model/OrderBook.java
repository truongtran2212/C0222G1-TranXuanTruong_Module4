package com.example.borrowbook.model;

import javax.persistence.*;

@Entity
@Table(name = "order_book")
public class OrderBook {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "code_book", referencedColumnName = "code_book")
    private Book book;

    public OrderBook() {
    }

    public OrderBook(String id, Book book) {
        this.id = id;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
