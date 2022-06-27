package com.example.borrowbook.service.impl;

import com.example.borrowbook.model.Book;

import com.example.borrowbook.repository.BookRepository;
import com.example.borrowbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findByCode(String codeBook) {
        return bookRepository.findByCode(codeBook);
    }

    @Override
    public void borrow(int quantity, String codeBook) {
        bookRepository.borrow(quantity, codeBook);
    }

    @Override
    public void returnBook(int quantity, String codeBook) {
        bookRepository.returnBook(quantity + 1, codeBook);
    }
}
