package com.example.borrowbook.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "code_book")
    private String codeBook;

    private String bookName;

    private String productionName;

    @ColumnDefault("0")
    private int status;

    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<OrderBook> orderBook;

    public Book() {
    }

    public Book(String codeBook, String bookName, String productionName, int status, int quantity, Set<OrderBook> orderBook) {
        this.codeBook = codeBook;
        this.bookName = bookName;
        this.productionName = productionName;
        this.status = status;
        this.quantity = quantity;
        this.orderBook = orderBook;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<OrderBook> getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(Set<OrderBook> orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "codeBook='" + codeBook + '\'' +
                ", bookName='" + bookName + '\'' +
                ", productionName='" + productionName + '\'' +
                ", status=" + status +
                ", quantity=" + quantity +
                ", orderBook=" + orderBook +
                '}';
    }
}
