package com.techouts.servlets;

import com.techouts.dao.UserDao;
import com.techouts.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateprofile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("userId", user.getId());
        request.setAttribute("userName", user.getUsername());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("phoneNumber", user.getPhoneNumber());
        request.setAttribute("name", user.getName());
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (UserDao.emailExists(request.getParameter("email"), user.getId()) > 0) {
            request.setAttribute("error", "Email already exists");
            doGet(request, response);
            return;
        }
        if (UserDao.phoneNumberExists(Long.parseLong(request.getParameter("phoneNumber")), user.getId()) > 0) {
            request.setAttribute("error", "Phone number already exists");
            doGet(request, response);
            return;
        }
        if (UserDao.usernameExists(request.getParameter("username"), user.getId()) > 0) {
            request.setAttribute("error", "Username already exists");
            doGet(request, response);
            return;
        }
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(Long.parseLong(request.getParameter("phoneNumber")));
        user.setName(request.getParameter("name"));
        if (UserDao.updateUser(user)) {
            request.getSession().setAttribute("username", user.getUsername());
            request.getSession().setAttribute("message", "Profile updated successfully");
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
