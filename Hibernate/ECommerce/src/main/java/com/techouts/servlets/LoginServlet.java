package com.techouts.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import com.techouts.dao.UserDao;
import com.techouts.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = UserDao.login(username, password);

        if (user != null) {
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/home").forward(req, res);
        } else {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }
}
