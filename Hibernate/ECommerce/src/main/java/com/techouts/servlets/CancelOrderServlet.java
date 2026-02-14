package com.techouts.servlets;

import com.techouts.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cancelorder")
public class CancelOrderServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (OrderDao.removeOrderById(Integer.parseInt(req.getParameter("id")))) {
            req.setAttribute("message", "Order has been cancelled");
            req.getRequestDispatcher("/orders").forward(req, resp);
        } else {
            req.setAttribute("message", "Order not cancelled");
            req.getRequestDispatcher("/orders").forward(req, resp);
        }
    }
}
