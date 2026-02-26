package com.techouts.controller;

import com.techouts.entity.Product;
import com.techouts.entity.User;
import com.techouts.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listProducts(@RequestParam(value = "category", required = false) String category, Model model, @AuthenticationPrincipal User user) {
        List<Product> products = productService.getAllProducts();
        if (category != null && !category.isEmpty()) {
            products.removeIf(p -> !category.equals(p.getCategory()));
        }
        model.addAttribute("products", products);
        model.addAttribute("user",user);
        return "product/product_list";
    }

    @GetMapping("/details/{id}")
    public String productDetails(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/product/list";
        }
        model.addAttribute("product", product);
        return "product/product_details";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/product_add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product,
                             @RequestParam("imageFile") MultipartFile imageFile,Model model) {
        try {
            productService.addProduct(product,imageFile);
            return "redirect:/product/list";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "product/product_add";
        }
    }

    @GetMapping("/update/{id}")
    public String updateProductForm(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/product/list";
        }
        model.addAttribute("product", product);
        return "product/product_update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product,
                                @RequestParam("imageFile") MultipartFile imageFile,Model model) {
        try{
            productService.updateProduct(product,imageFile);
            return "redirect:/product/list";
        }catch (IllegalArgumentException e){
            model.addAttribute("error", e.getMessage());
            return "product/product_update";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProduct(product);
        }
        return "redirect:/product/list";
    }
}