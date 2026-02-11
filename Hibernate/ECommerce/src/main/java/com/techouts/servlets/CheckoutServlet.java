package com.techouts.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

import com.techouts.dao.OrderDao;
import com.techouts.entities.*;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Order order = new Order();
        order.setUser((User) req.getAttribute("user"));
        order.setOrderDate(new Date());
        order.setPaymentType(req.getParameter("paymentType"));
        order.setStatus("PLACED");
        MyCart myCart = new MyCart();
        double totalAmount = 0;
        List<OrderItem> items = new ArrayList<>();

        order.setAddress(req.getParameter("address"));
        order.setTotalAmount(totalAmount);
        order.setItems(items);

        if (OrderDao.saveOrder(order)) {
            req.removeAttribute("cart");
            req.setAttribute("orders", order);
            req.setAttribute("items", items);
            res.sendRedirect("order/success.jsp");
        } else {
            res.sendRedirect("order/failure.jsp");
        }
    }
}
