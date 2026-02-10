package com.techouts.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import org.hibernate.Session;

import com.techouts.entities.*;
import com.techouts.util.HibernateUtil;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int productId = Integer.parseInt(req.getParameter("productId"));

        Session hSession = HibernateUtil.getSessionFactory().openSession();
        Product product = hSession.get(Product.class, productId);
        hSession.close();

        HttpSession session = req.getSession();
        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) cart = new ArrayList<>();

        boolean found = false;
        for (CartItem item : cart) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) cart.add(new CartItem(product, 1));

        session.setAttribute("cart", cart);
        res.sendRedirect("cart/cart.jsp");
    }
}
