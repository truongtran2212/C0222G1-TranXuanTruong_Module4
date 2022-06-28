package com.example.cart.repository;

import com.example.cart.model.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Query(value = "select c from Product c ")
    List<Product> findAll();


}
