package com.techouts.servlets;

import com.techouts.dao.ProductDao;
import com.techouts.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Product product = ProductDao.getProductByName(req.getParameter("name"));
        if(product==null){
            req.getSession().setAttribute("error", "Product doesn't exist");
            req.getRequestDispatcher("/home").forward(req, res);
        }
        String name = req.getParameter("name");
        product.setName(name);
        product.setPrice(Integer.parseInt(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setImageUrl(ProductDao.getImageName(product.getId()));
        ProductDao.updateProduct(product);
        req.getSession().setAttribute("message", "Product updated successfully");
        req.getRequestDispatcher("/home").forward(req, res);
    }
}
