package com.example.productjpa.service;

import com.example.productjpa.model.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    void create(String nameProduct, double priceProduct, String detailProduct, String production);

    void delete(int id);

    Product findById(int id);

    void update(String nameProduct, double priceProduct, String detailProduct, String production, int id);

    Page<Product> search(String nameProduct, Pageable pageable);

}
