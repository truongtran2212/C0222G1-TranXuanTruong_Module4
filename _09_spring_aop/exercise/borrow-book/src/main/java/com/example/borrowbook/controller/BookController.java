package com.example.borrowbook.controller;

import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.OrderBook;
import com.example.borrowbook.service.BookService;
import com.example.borrowbook.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderBookService orderBookService;

    @GetMapping("/list")
    public String showListBook(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("bookList", bookService.findAll(PageRequest.of(page, 3)));
        return "index";
    }

    @GetMapping("{codeBook}/borrow")
    public String showDetail(@PathVariable("codeBook") String codeBook, Model model) {
        model.addAttribute("book", bookService.findByCode(codeBook));
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrow(Book book) {
        bookService.borrow(book.getQuantity(), book.getCodeBook());
        int random = (int) (Math.random() * 99999);
        String id = String.valueOf(random);

        orderBookService.create(id, book.getCodeBook());
        return "redirect:/list";
    }

    @GetMapping("/return")
    public String showReturn(@RequestParam("id") String id) {
        OrderBook orderBook = orderBookService.findId(id);
        Book book = orderBook.getBook();
        bookService.returnBook(book.getQuantity(), book.getCodeBook());
        orderBookService.delete(orderBook.getId());

        return "redirect:/list";
    }

    @ExceptionHandler(Exception.class)
    public String handlerException() {
        return "error";
    }
}
