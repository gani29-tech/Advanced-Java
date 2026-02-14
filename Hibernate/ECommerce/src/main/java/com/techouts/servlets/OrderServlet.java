package com.techouts.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.techouts.dao.OrderDao;
import com.techouts.entities.Order;
import com.techouts.entities.User;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;
        if (user == null) {
            res.sendRedirect("login.jsp");
            return;
        }
        List<Order> orders = OrderDao.getOrders(user.getId());
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("order/orders.jsp").forward(req, res);
    }
}
