package com.techouts.servlets;

import com.techouts.dao.MyCartDao;
import com.techouts.dao.OrderDao;
import com.techouts.dao.ProductDao;
import com.techouts.entities.CartItem;
import com.techouts.entities.Order;
import com.techouts.entities.Product;
import com.techouts.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/orderitem")
public class OrderItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = ProductDao.getProductById(Integer.parseInt(request.getParameter("productId")));
        request.setAttribute("product", product);
        request.getRequestDispatcher("cart/orderitem.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Order order = new Order();
        User user = (User)req.getSession().getAttribute("user");
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setPaymentType(req.getParameter("paymentType"));
        order.setStatus("Order Placed");
        Product product = ProductDao.getProductById(Integer.parseInt(req.getParameter("productId")));
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        order.setItems(cartItems);
        order.setAddress(req.getParameter("address"));
        order.setTotalAmount(product.getPrice());
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
