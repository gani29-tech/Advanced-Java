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
        UserDao userDao = new UserDao();
        user.setName(req.getParameter("name"));
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        if(userDao.emailExists(user.getEmail())){
            req.setAttribute("error", "Email already exists!");
            req.getRequestDispatcher("/signup.jsp").forward(req, res);
        }
        if(userDao.usernameExists(user.getUsername())){
            req.setAttribute("error", "Username already exists!");
            req.getRequestDispatcher("/signup.jsp").forward(req, res);
        }
        user.setPassword(req.getParameter("password"));
        user.setPhoneNumber(Long.parseLong(req.getParameter("phonenumber")));
        if(userDao.phoneNumberExists(user.getPhoneNumber())){
            req.setAttribute("error", "Phone Number already exists!");
            req.getRequestDispatcher("/signup.jsp").forward(req, res);
        }
        MyCart  myCart = new MyCart();
        user.setMyCart(myCart);
        if(userDao.saveUser(user)) {
        	res.sendRedirect("login.jsp");
        }
        else {
        	req.getRequestDispatcher("signup.jsp").forward(req, res);
        }
    }
}