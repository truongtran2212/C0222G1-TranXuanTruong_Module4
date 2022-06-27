package com.example.borrowbook.repository;

import com.example.borrowbook.model.OrderBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface OrderBookRepository extends PagingAndSortingRepository<OrderBook, String> {

    @Query(value = "select o from OrderBook o")
    Page<OrderBook> findAll(Pageable pageable);

    @Modifying
    @Query(value = "insert into order_book values (:id,:codeBook)", nativeQuery = true)
    void create(@Param("id") String id, @Param("codeBook") String codeBook);

    @Query(value = "select * from order_book where id = :id", nativeQuery = true)
    OrderBook findId(@Param("id") String id);

    @Modifying
    @Query(value = "delete from order_book where id = :id", nativeQuery = true)
    void delete(@Param("id") String id);

}
