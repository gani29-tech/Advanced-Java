package com.techouts.servlets;

import com.techouts.dao.ProductDao;
import com.techouts.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setPrice(Integer.parseInt(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setImageUrl(req.getParameter("imageUrl"));
        product.setCategory(req.getParameter("category"));
        ProductDao productDao = new ProductDao();
        if (ProductDao.getProductByName(req.getParameter("name"))) {
            req.getSession().setAttribute("message", "Product already exists");
            res.sendRedirect(req.getContextPath() + "/home");
            return;
        }
        productDao.saveProduct(product);
        req.getSession().setAttribute("message", "Product added successfully");
        res.sendRedirect(req.getContextPath() + "/home");
    }
}
