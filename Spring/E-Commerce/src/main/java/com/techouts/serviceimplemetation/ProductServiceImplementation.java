package com.techouts.serviceimplemetation;

import com.techouts.entity.Product;
import com.techouts.repository.ProductRepo;
import com.techouts.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
@Service
public class ProductServiceImplementation implements ProductService {
    private final ProductRepo productRepo;
    public ProductServiceImplementation(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public void addProduct(Product product, MultipartFile file){
        if(productExists(product.getName(),product.getId())){
            throw new IllegalArgumentException("Product already exists");
        }
        try {
            if(!file.isEmpty()) {
                String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path uploadPath = Paths.get("uploads/products");
                if(!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Files.copy(file.getInputStream(), uploadPath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
                product.setImage(filename);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        productRepo.addProduct(product);
    }

    @Override
    public void deleteProduct(String name) {
        productRepo.deleteProduct(name);
    }

    @Override
    public void updateProduct(Product product, MultipartFile file) {
        Product existingProduct = getProductById(product.getId());
        if(productExists(product.getName(),product.getId())){
            throw new IllegalArgumentException("Product already exists");
        }
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
    }

    @Override
    public Product getProductByName(String name) {
        return productRepo.getProductByName(name);
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.getAllProducts();
    }

    @Override
    public boolean productExists(String name,int id) {
        return productRepo.productExists(name,id);
    }
}
