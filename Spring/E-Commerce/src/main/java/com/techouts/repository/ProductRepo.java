package com.techouts.repository;

import com.techouts.entity.Product;

import java.util.List;

public interface ProductRepo {
    void addProduct(Product product);
    void deleteProduct(String name);
    Product getProductById(int id);
    Product getProductByName(String name);
    boolean productExists(String name,int id);
    List<Product> getAllProducts();

}
