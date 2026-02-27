package com.techouts.controller;

import com.techouts.entity.Product;
import com.techouts.entity.User;
import com.techouts.service.ProductService;
import com.techouts.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final ProductService productService;
    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user,Model model) {
        try{
            userService.saveUser(user);
            return "redirect:/login";
        }catch (IllegalArgumentException e){
            model.addAttribute("error",e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model, @AuthenticationPrincipal User u,
                       @RequestParam(name = "category", defaultValue = "All") String category) {
        User user = userService.getUserById(u.getId());
        List<Product> products;
        if(category.equalsIgnoreCase("All"))
            products = productService.getAllProducts();
        else
            products = productService.getProductsByCategory(category);
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        model.addAttribute("categories", productService.getAllCategories().stream().distinct().sorted().toList());
        model.addAttribute("products", products);
        model.addAttribute("selectedCategory", category);
        return "home";
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
    @GetMapping("/user/update")
    public String updateUserForm(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "user_update";
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User user,Model model) {
        try {
            userService.updateUser(user);
            return "redirect:/home";
        }
        catch (IllegalArgumentException e){
            model.addAttribute("error",e.getMessage());
            return "user_update";
        }
    }
}