package com.techouts.controller;

import com.techouts.entity.User;
import com.techouts.service.ProductService;
import com.techouts.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String home(HttpSession session,Model model, @AuthenticationPrincipal User u) {
        User user = userService.getUserById(u.getId());
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        model.addAttribute("categories", productService.getAllCategories());
        model.addAttribute("products", productService.getAllProducts());
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

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout=true";
    }
}