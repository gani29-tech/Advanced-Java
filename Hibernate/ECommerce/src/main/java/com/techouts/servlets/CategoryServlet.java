package com.techouts.servlets;

import com.techouts.dao.ProductDao;
import com.techouts.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = ProductDao.getProductsByCategory(request.getParameter("category"));
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
