package com.example.borrowbook.service;

import com.example.borrowbook.model.OrderBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface OrderBookService {
    Page<OrderBook> findAll(Pageable pageable);

    void create(String id, String codeBook);

    OrderBook findId(String id);

    void delete (String id);
}
