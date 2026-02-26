package com.techouts.service;

import com.techouts.entity.Order;
import com.techouts.entity.User;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    Order getOrderById(long id);
    List<Order> getOrdersByUser(User user);
}