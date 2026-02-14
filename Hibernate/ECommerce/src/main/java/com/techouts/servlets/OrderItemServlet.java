package com.techouts.servlets;

import com.techouts.dao.OrderDao;
import com.techouts.dao.ProductDao;
import com.techouts.entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/orderitem")
public class OrderItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productId", request.getParameter("productId"));
        request.getRequestDispatcher("cart/orderitem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Order order = new Order();
        User user = (User) req.getSession().getAttribute("user");
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setPaymentType(req.getParameter("paymentType"));
        order.setStatus("Order Placed");
        order.setAddress(req.getParameter("address"));
        OrderItem orderItem = new OrderItem();
        Product product = ProductDao.getProductById(Integer.parseInt(req.getParameter("productId")));
        orderItem.setOrderPrice(product.getPrice());
        order.setTotalAmount(product.getPrice());
        orderItem.setProduct(product);
        orderItem.setQuantity(1);
        orderItem.setOrder(order);
        order.getItems().add(orderItem);
        if (OrderDao.saveOrder(order)) {
            req.setAttribute("orderId", order.getId());
            req.setAttribute("orders", order);
            req.getRequestDispatcher("order/success.jsp").forward(req, res);
        } else {
            res.sendRedirect("order/failure.jsp");
        }
    }
}
