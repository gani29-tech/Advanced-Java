package com.techouts.controller;

import com.techouts.entity.Cart;
import com.techouts.entity.CartItem;
import com.techouts.entity.Product;
import com.techouts.entity.User;
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
        System.out.println(cart.getId());
        model.addAttribute("cart", cart);
        return "cart/cart";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable(value = "productId") long productId,HttpSession session) {
        User user = (User) session.getAttribute("user");
        Product product = productService.getProductById(productId);
        Cart cart = cartService.getCartByUser(user);
        cart.getCartItems();
        for (CartItem item : cart.getCartItems()) {
            if(item.getProduct().getId() == product.getId()){
                item.setQuantity(item.getQuantity() + 1);
            }
            else {
                cartService.addCartItem(user,product,1);
            }
        }
        return "redirect:/cart/show";
    }

    @GetMapping("/update/{itemId}")
    public String updateCartItem(@PathVariable(value = "itemId") long itemId, @RequestParam("quantity") int quantity) {
        cartService.updateCartItem(itemId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{itemId}")
    public String removeCartItem(@PathVariable(value = "itemId") long itemId) {
        cartService.removeCartItem(itemId);
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        cartService.checkout(user);
        return "redirect:/order/success";
    }
}