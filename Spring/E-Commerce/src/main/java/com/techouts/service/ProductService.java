package com.techouts.service;

import com.techouts.entity.Product;
import com.techouts.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product, MultipartFile imageFile);
    Product updateProduct(Product product,MultipartFile imageFile);
    void deleteProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<String> getAllCategories();
}