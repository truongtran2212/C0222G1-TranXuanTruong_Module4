package com.example.borrowbook.repository;

import com.example.borrowbook.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends PagingAndSortingRepository<Book, String> {

    @Query(value = "Select b from Book b where b.status = 0")
    Page<Book> findAll(Pageable pageable);

    @Query(value = "select b from Book b where b.codeBook = :codeBook")
    Book findByCode(@Param("codeBook") String codeBook);

    @Modifying
    @Query(value = "update Book b set b.quantity = (:quantity - 1) where b.codeBook = :codeBook")
    void borrow(@Param("quantity") int quantity, @Param("codeBook") String codeBook);

    @Modifying
    @Query(value = "update Book set quantity = :quantity where codeBook = :codeBook")
    void returnBook(@Param("quantity") int quantity, @Param("codeBook") String codeBook);
}
