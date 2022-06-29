package com.example.cart.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> productIntegerMap = new LinkedHashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public Map<Product, Integer> getProductIntegerMap() {
        return productIntegerMap;
    }

    public void setProductIntegerMap(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> item : productIntegerMap.entrySet()) {
            if (item.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> item : productIntegerMap.entrySet()) {
            if (item.getKey().getId().equals(product.getId())) {
                return item;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            productIntegerMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> productMap = selectItemInCart(product);
            int newQuantity = productMap.getValue() + 1;
            productIntegerMap.replace(productMap.getKey(), newQuantity);
        }
    }

    public Integer countProductQuantity() {
        Integer countQuantity = 0;
        for (Map.Entry<Product, Integer> item : productIntegerMap.entrySet()) {
            countQuantity += item.getValue();
        }
        return countQuantity;
    }
}
