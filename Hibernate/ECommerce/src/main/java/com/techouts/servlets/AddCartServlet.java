package com.techouts.servlets;

import com.techouts.dao.MyCartDao;
import com.techouts.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            res.sendRedirect("login.jsp");
            return;
        }
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        MyCartDao myCartDao = new MyCartDao();
        boolean added = myCartDao.addCartItem(user.getId(), productId, quantity);
        if (added) {
            req.getSession().setAttribute("message", "Product added to cart");
            res.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("error", "Product not added to cart");
            res.sendRedirect(req.getContextPath() + "/home");
        }
    }
}
