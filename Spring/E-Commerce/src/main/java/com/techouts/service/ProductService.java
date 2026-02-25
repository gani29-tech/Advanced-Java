package com.techouts.service;

import com.techouts.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    void addProduct(Product product, MultipartFile file);
    void deleteProduct(String name);
    void updateProduct(Product product, MultipartFile file);
    Product getProductByName(String name);
    boolean productExists(String name,int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
}
