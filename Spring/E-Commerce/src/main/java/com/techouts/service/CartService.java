package com.techouts.service;

import com.techouts.entity.Cart;
import com.techouts.entity.CartItem;
import com.techouts.entity.Product;
import com.techouts.entity.User;

public interface CartService {
    Cart getCartByUser(User user);
    void addCartItem(User user, Product product, int quantity);
    void updateCartItem(long itemId, int quantity);
    void removeCartItem(long itemId);
    void checkout(User user);
    CartItem getCartItemByProductId(long productId);
}