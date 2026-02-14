package com.techouts.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.techouts.dao.UserDao;
import com.techouts.entities.MyCart;
import com.techouts.entities.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        User user = new User();
        user.setName(req.getParameter("name"));
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        if (UserDao.emailExists(user.getEmail(), user.getId()) != 0) {
            req.setAttribute("error", "Email already exists!");
            req.getRequestDispatcher("/signup.jsp").forward(req, res);
            return;
        }
        if (UserDao.usernameExists(user.getUsername(), user.getId()) != 0) {
            req.setAttribute("error", "Username already exists!");
            req.getRequestDispatcher("/signup.jsp").forward(req, res);
            return;
        }
        user.setPassword(req.getParameter("password"));
        user.setPhoneNumber(Long.parseLong(req.getParameter("phonenumber")));
        if (UserDao.phoneNumberExists(user.getPhoneNumber(), user.getId()) != 0) {
            req.setAttribute("error", "Phone Number already exists!");
            req.getRequestDispatcher("/signup.jsp").forward(req, res);
            return;
        }
        MyCart myCart = new MyCart();
        user.setMyCart(myCart);
        if (UserDao.saveUser(user)) {
            res.sendRedirect("login.jsp");
        } else {
            req.getRequestDispatcher("signup.jsp").forward(req, res);
        }
    }
}