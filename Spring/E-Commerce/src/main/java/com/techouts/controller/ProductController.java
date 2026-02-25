package com.techouts.controller;

import com.techouts.entity.Product;
import com.techouts.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product",new Product());
        return "product/add_product";
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, @RequestParam("imageFile") MultipartFile file, Model model) {
        try{
            productService.addProduct(product, file)
            return "/product/product_list";
        }catch (RuntimeException e){
            model.addAttribute("error",e.getMessage());
            model.addAttribute("product",product);
            return "product/add_product";
        }
    }
    @GetMapping("/update")
    public String updateProduct() {
        return "product/update_product";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("imageFile") MultipartFile file, Model model) {
        try{
            productService.updateProduct(product,file);
            return "redirect:/product/product_list";
        } catch (RuntimeException e) {
            model.addAttribute("error",e.getMessage());
            model.addAttribute("product",product);
            return "update_product";
        }
    }
    @GetMapping("/delete")
    public String deleteProduct() {
        return "product/delete_product";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("name") String name,Model model) {
        try{
            productService.deleteProduct(name);
            return "/product/product_list";
        }catch (RuntimeException e){
            model.addAttribute("error",e.getMessage());
            return "product/delete_product";
        }
    }
    @GetMapping("/details")
    public String details(@RequestParam int id, Model model) {
        model.addAttribute("product",productService.getProductById(id));
        return "product/details";
    }
    @PostMapping("/details")
    public String productDetails(@RequestParam("id") int id,Model model) {
        try{
            Product product = productService.getProductById(id);
            model.addAttribute("product",product);
            return "product/product_details";
        }catch (RuntimeException e){
            model.addAttribute("error",e.getMessage());
            return "product/product_list";
        }
    }
    @GetMapping("/list")
    public String productList(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "product/product_list";
    }
}
