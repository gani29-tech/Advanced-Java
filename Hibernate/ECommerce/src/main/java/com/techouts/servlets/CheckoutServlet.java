package com.techouts.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

import com.techouts.dao.MyCartDao;
import com.techouts.dao.OrderDao;
import com.techouts.dao.ProductDao;
import com.techouts.entities.*;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Order order = new Order();
        User user = (User)req.getSession().getAttribute("user");
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setPaymentType(req.getParameter("paymentType"));
        order.setStatus("Order Placed");
        order.setItems((List<CartItem>) req.getSession().getAttribute("cartItemsList"));
        order.setAddress(req.getParameter("address"));
        order.setTotalAmount((Double) req.getSession().getAttribute("totalPrice"));
        if (OrderDao.saveOrder(order)) {
            req.removeAttribute("cart");
            MyCartDao myCartDao = new MyCartDao();
            myCartDao.clearCart(user.getId());
            req.setAttribute("orders", order);
            res.sendRedirect("order/success.jsp");
        } else {
            res.sendRedirect("order/failure.jsp");
        }
    }
}
