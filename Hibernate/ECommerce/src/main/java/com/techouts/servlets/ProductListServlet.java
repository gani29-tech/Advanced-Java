package com.techouts.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.Session;

import com.techouts.entities.Product;
import com.techouts.util.HibernateUtil;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("from Product", Product.class).list();
        session.close();

        req.setAttribute("products", products);
        req.getRequestDispatcher("home.jsp").forward(req, res);
    }
}
