package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void create(Product product);

    void delete(int id);

    Product findById(int id);

    void update(Product product);

    List<Product> search(String nameProduct);
}
