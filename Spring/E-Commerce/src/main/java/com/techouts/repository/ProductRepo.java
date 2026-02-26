package com.techouts.repository;

import com.techouts.entity.Product;
import com.techouts.entity.User;

import java.util.List;

public interface ProductRepo {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
    boolean productExists(String name,long id);
    Product findById(Long id);
    List<Product> findAll();
    List<String> getAllCategories();
}