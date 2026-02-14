package com.techouts.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

import com.techouts.dao.MyCartDao;
import com.techouts.dao.OrderDao;
import com.techouts.entities.*;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Order order = new Order();
        User user = (User) req.getSession().getAttribute("user");
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setPaymentType(req.getParameter("paymentType"));
        order.setStatus("Order Placed");
        Set<CartItem> cartItems = MyCartDao.getCartItems(user.getId());
        order.setAddress(req.getParameter("address"));
        MyCart myCart = MyCartDao.getCartByUser(user);
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrderPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
            orderItem.setOrder(order);
            order.getItems().add(orderItem);
        }
        order.setTotalAmount(myCart.getTotalPrice());
        if (OrderDao.saveOrder(order)) {
            req.removeAttribute("cart");
            MyCartDao.clearCart(user.getId());
            req.setAttribute("orderId", order.getId());
            req.setAttribute("orders", order);
            req.getRequestDispatcher("order/success.jsp").forward(req, res);
        } else {
            res.sendRedirect("order/failure.jsp");
        }
    }
}
