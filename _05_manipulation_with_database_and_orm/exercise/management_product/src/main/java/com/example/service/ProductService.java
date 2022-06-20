package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void create(Product product);

    void delete(int id);

    Product findById(int id);

    void update(Product product);

    List<Product> search(String nameProduct);
}
