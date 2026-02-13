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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if(MyCartDao.removeCartItem(id)){
            req.getSession().setAttribute("message","Product has been removed from cart");
            res.sendRedirect(req.getContextPath()+"/displaycart");
        }
        else{
            req.getSession().setAttribute("message","Product not removed from cart");
            req.getRequestDispatcher("/home").forward(req, res);
        }
    }
}
