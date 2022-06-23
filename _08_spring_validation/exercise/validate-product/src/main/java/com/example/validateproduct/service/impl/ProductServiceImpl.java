package com.example.validateproduct.service.impl;

import com.example.validateproduct.model.Product;
import com.example.validateproduct.repository.ProductRepository;
import com.example.validateproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void create(String nameProduct, double priceProduct, String detailProduct, String production) {
        productRepository.create(nameProduct, priceProduct, detailProduct, production);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(String nameProduct, double priceProduct, String detailProduct, String production, int id) {
        productRepository.update(nameProduct, priceProduct, detailProduct, production, id);
    }

    @Override
    public Page<Product> search(String nameProduct, Pageable pageable) {
        return productRepository.search(nameProduct, pageable);
    }
}