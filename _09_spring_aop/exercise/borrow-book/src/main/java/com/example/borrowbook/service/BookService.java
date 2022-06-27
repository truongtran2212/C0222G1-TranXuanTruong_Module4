package com.example.borrowbook.service;

import com.example.borrowbook.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findByCode(String codeBook);

    void borrow(int quantity, String codeBook);

    void returnBook(int quantity, String codeBook);


}
