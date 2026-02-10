package com.techouts.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.techouts.entities.Order;
import com.techouts.entities.User;
import com.techouts.util.HibernateUtil;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession httpSession = req.getSession(false);
        User user = (httpSession != null) ? (User) httpSession.getAttribute("user"): null;

        if (user == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Order> query = session.createQuery(
                "from Order o where o.user.id = :uid order by o.orderDate desc",
                Order.class);
        query.setParameter("uid", user.getId());

        List<Order> orders = query.list();
        session.close();

        req.setAttribute("orders", orders);
        req.getRequestDispatcher("order/orders.jsp").forward(req, res);
    }
}
