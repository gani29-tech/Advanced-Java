package com.techouts.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

import com.techouts.dao.OrderDao;
import com.techouts.entities.*;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (user == null || cart == null || cart.isEmpty()) {
            res.sendRedirect("order/failure.jsp");
            return;
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setStatus("PLACED");

        double total = 0;
        List<OrderItem> items = new ArrayList<>();

        for (CartItem ci : cart) {
            total += ci.getTotalPrice();

            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(ci.getProduct());
            oi.setQuantity(ci.getQuantity());
            oi.setPrice(ci.getProduct().getPrice());
            items.add(oi);
        }

        order.setTotalAmount(total);
        order.setItems(items);

        boolean success = OrderDao.saveOrder(order);

        if (success) {
            session.removeAttribute("cart");
            res.sendRedirect("order/success.jsp");
        } else {
            res.sendRedirect("order/failure.jsp");
        }
    }
}
