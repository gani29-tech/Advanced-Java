package com.techouts.servlets;

import com.techouts.dao.UserDao;
import com.techouts.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        User user = (User) req.getSession(false).getAttribute("user");
        UserDao userDao = new UserDao();
        user.setName(req.getParameter("name"));
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        if(userDao.emailExists(user.getEmail())){
            req.setAttribute("error", "Email already exists!");
            req.getRequestDispatcher("profile.jsp").forward(req, res);
        }
        if(userDao.usernameExists(user.getUsername())){
            req.setAttribute("error", "Username already exists!");
            req.getRequestDispatcher("profile.jsp").forward(req, res);
        }
        user.setPassword(req.getParameter("password"));
        user.setPhoneNumber(Long.parseLong(req.getParameter("phonenumber")));
        if(userDao.phoneNumberExists(user.getPhoneNumber())){
            req.setAttribute("error", "Phone Number already exists!");
            req.getRequestDispatcher("profile.jsp").forward(req, res);
        }
        if(userDao.updateUser(user)) {
            req.getSession().setAttribute("message", "Profile updated successfully!");
            req.getRequestDispatcher("/login").forward(req, res);
        }
        else {
            req.setAttribute("error", "Profile not Updated");
            req.getRequestDispatcher("profile.jsp").forward(req, res);
        }
    }
}
