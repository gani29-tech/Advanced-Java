package com.techouts.serviceimplementation;

import com.techouts.entity.Cart;
import com.techouts.entity.CartItem;
import com.techouts.entity.Order;
import com.techouts.entity.OrderItem;
import com.techouts.entity.Product;
import com.techouts.entity.User;
import com.techouts.repository.CartRepo;
import com.techouts.repository.OrderRepo;
import com.techouts.service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartServiceImplementation implements CartService {

    private final CartRepo cartRepo;
    private final OrderRepo orderRepo;

    public CartServiceImplementation(CartRepo cartRepo, OrderRepo orderRepo) {
        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public Cart getCartByUser(User user) {
        Cart cart = cartRepo.getCartByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cartRepo.save(cart);
        }
        return cart;
    }

    @Override
    @Transactional
    public void addCartItem(User user, Product product, int quantity) {
        Cart cart = getCartByUser(user);
        System.out.println("cart id is : "+cart.getId());
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setCart(cart);
        cart.getCartItems().add(item);
        cartRepo.save(cart);
    }

    @Override
    @Transactional
    public void updateCartItem(long itemId, int quantity) {
        CartItem item = getCartItemById(itemId);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    @Override
    @Transactional
    public void removeCartItem(long itemId) {
        CartItem item = getCartItemById(itemId);
        if (item != null) {
            Cart cart = item.getCart();
            cart.getCartItems().remove(item);
            cartRepo.save(cart);
        }
    }

    @Override
    @Transactional
    public void checkout(User user) {
        Cart cart = getCartByUser(user);
        if (cart.getCartItems().isEmpty()) return;

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());

        double total = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);

            total += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        }

        order.setTotalAmount(total);
        orderRepo.save(order);

        cart.getCartItems().clear();
        cartRepo.save(cart);
    }

    @Override
    public CartItem getCartItemByProductId(long productId) {
       return cartRepo.getCartItemByProductId(productId);
    }

    private CartItem getCartItemById(long id) {
        return null;
    }
}