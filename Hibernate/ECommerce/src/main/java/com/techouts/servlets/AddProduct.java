package com.techouts.servlets;

import com.techouts.dao.ProductDao;
import com.techouts.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/addProduct")
    @MultipartConfig
public class AddProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        int price = Integer.parseInt(req.getParameter("price"));
        Part filePart = req.getPart("imageUrl");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            String extension = filePart.getSubmittedFileName().substring(filePart.getSubmittedFileName().lastIndexOf("."));
            String safeName = name.trim().replaceAll("\\s+", "_");
            fileName = safeName + "_" + System.currentTimeMillis() + extension;
            String uploadPath = getServletContext().getRealPath("") + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();
            filePart.write(uploadPath + File.separator + fileName);
        }
        if (ProductDao.getProductByName(req.getParameter("name")) != null) {
            req.getSession().setAttribute("error", "Product already exists");
            res.sendRedirect("products/addProduct.jsp");
            return;
        }
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);
        product.setImageUrl(fileName);
        ProductDao.saveProduct(product);
        req.getSession().setAttribute("message", "Product added successfully");
        res.sendRedirect(req.getContextPath() + "/home");
    }
}

