package com.techouts.servlets;

import com.techouts.dao.ProductDao;
import com.techouts.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Product product = ProductDao.getProductByName(req.getParameter("name"));
        if (ProductDao.deleteProduct(product)>0) {
            req.getSession().setAttribute("message", "Product Deleted Successfully");
            String fileName = product.getImageUrl();
            if (fileName != null) {
                String imagePath = getServletContext().getRealPath("") + "images" + File.separator + fileName;
                File file = new File(imagePath);
                if (file.exists()) file.delete();
            }
        } else {
            req.getSession().setAttribute("error", "Product doesn't exist");
        }
        req.getRequestDispatcher("/home").forward(req, res);
    }
}
