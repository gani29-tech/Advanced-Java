package com.techouts.controller;

import com.techouts.entity.*;
import com.techouts.service.CartService;
import com.techouts.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/show")
    public String viewCart(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Cart cart = cartService.getCartByUser(user);
        model.addAttribute("cart", cart);
        return "cart/cart";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") long productId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Product product = productService.getProductById(productId);
        cartService.addCartItem(user, product);
        return "redirect:/home";
    }

    @PostMapping("/update/{itemId}")
    public String updateCartItem(@PathVariable(value = "itemId") long itemId, @RequestParam("quantity") int quantity) {
        cartService.updateCartItem(itemId, quantity);
        return "redirect:/cart/show";
    }

    @PostMapping("/remove/{itemId}")
    public String removeCartItem(@PathVariable(value = "itemId") long itemId) {
        cartService.removeCartItem(itemId);
        return "redirect:/cart/show";
    }
    @GetMapping("/checkout")
    public String checkoutForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Cart cart = cartService.getCartByUser(user);
        model.addAttribute("cart", cart);
        return "cart/checkout";
    }
    @PostMapping("/checkout")
    public String checkout(@ModelAttribute CheckoutRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cartService.checkout(user,request);
        return "redirect:/order/success";
    }
}