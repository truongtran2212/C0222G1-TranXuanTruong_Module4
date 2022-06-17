package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Note 9 ", 1000, "ok", "SamSung"));
        productList.add(new Product(2, "Note 10 ", 1000, "ok", "SamSung"));
        productList.add(new Product(3, "oppo A12s", 1000, "ok", "Oppo"));
        productList.add(new Product(4, "iphone 13 ", 1000, "ok", "Apple"));
        productList.add(new Product(5, "iphone X ", 1000, "ok", "Apple"));
        productList.add(new Product(6, "iphone 6 ", 1000, "ok", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, product);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String nameProduct) {
        List<Product> productSearch = new ArrayList<>();

        for (Product product : productList) {
            if (product.getNameProduct().contains(nameProduct)) {
                productSearch.add(product);
            }
        }
        return productSearch;
    }
}