package com.techouts.servlets;

import com.techouts.dao.MyCartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/removecart")
public class RemoveCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if(MyCartDao.removeCartItem(id)){
            req.setAttribute("message","Product Removed from cart");
            req.getRequestDispatcher("/cart.jsp").forward(req, res);
        }
        else{
            req.setAttribute("message","Product not removed from cart");
            req.getRequestDispatcher("home.jsp").forward(req, res);
        }
    }
}
