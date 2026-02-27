package com.techouts.controller;

import com.techouts.entity.Order;
import com.techouts.entity.User;
import com.techouts.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String orderHistory(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("orders", orderService.getOrdersByUser(user));
        return "order/order_list";
    }

    @GetMapping("/details/{orderId}")
    public String orderDetails(@PathVariable("orderId") long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order/order_details";
    }
    @GetMapping("/cancel/{orderId}")
    public String cancelOrder(@PathVariable("orderId") long orderId, Model model,HttpSession session) {
        if(orderService.cancelOrder(orderId)){
            model.addAttribute("message", "Order has been cancelled");
        }
        else {
            model.addAttribute("message", "Order not cancelled");
        }
        List<Order> orders = orderService.getOrdersByUser((User) session.getAttribute("user"));
        model.addAttribute("orders", orders);
        return "order/order_list";
    }
    @GetMapping("/success")
    public String orderSuccess() {
        return "order/order_success";
    }
}