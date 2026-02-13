package com.techouts.servlets;

import com.techouts.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        int rows = productDao.deleteProduct(req.getParameter("name"));
        if (rows > 0) {
            req.getSession().setAttribute("message","Product Deleted Successfully");
        } else {
            req.setAttribute("error", "Product doesn't exist");
        }
        req.getRequestDispatcher("/home").forward(req, res);
    }
}
