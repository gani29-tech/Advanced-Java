package com.techouts.controller;

import com.techouts.entity.Order;
import com.techouts.entity.User;
import com.techouts.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/history")
    public String orderHistory(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("orders", orderService.getOrdersByUser(user));
        return "order_history";
    }

    @GetMapping("/details/{orderId}")
    public String orderDetails(@PathVariable long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order_details";
    }

    @GetMapping("/success")
    public String orderSuccess() {
        return "order_success";
    }
}