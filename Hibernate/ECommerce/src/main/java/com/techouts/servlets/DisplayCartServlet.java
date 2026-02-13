package com.techouts.servlets;

import com.techouts.dao.MyCartDao;
import com.techouts.entities.MyCart;
import com.techouts.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/displaycart")
public class DisplayCartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
        }
        MyCart myCart = MyCartDao.getCartByUser(user);
        request.getSession().setAttribute("cartItemsList", myCart.getCartItems());
        request.getSession().setAttribute("totalPrice", myCart.getTotalPrice());
        request.getRequestDispatcher("/cart/cart.jsp").forward(request, response);
    }

}
