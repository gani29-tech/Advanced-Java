package com.techouts.servlets;

import com.techouts.dao.MyCartDao;
import com.techouts.dao.ProductDao;
import com.techouts.entities.CartItem;
import com.techouts.entities.MyCart;
import com.techouts.entities.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        MyCart myCart = (MyCart) req.getSession().getAttribute("myCart");
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        ProductDao productDao = new ProductDao();
        Product product = productDao.getProductById(Integer.parseInt(req.getParameter("productId")));
        cartItem.setProduct(product);
        if (myCart.getCartItems() == null) {
            myCart.setCartItems(new ArrayList<>());
        }
        myCart.getCartItems().add(cartItem);
        cartItem.setMyCart(myCart);
        MyCartDao myCartDao = new MyCartDao();
        if(myCartDao.addCartItem(myCart)){
            req.setAttribute("message","Product added to cart");
            req.setAttribute("cartItems",myCart.getCartItems());
            req.getRequestDispatcher("cart/cart.jsp").forward(req, res);
        }
        else{
            req.setAttribute("error","Product not added to cart");
            req.getRequestDispatcher("/home").forward(req, res);
        }
    }
}
