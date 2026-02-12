package com.techouts.dao;

import com.techouts.entities.CartItem;
import com.techouts.entities.MyCart;
import com.techouts.entities.Product;
import com.techouts.entities.User;
import com.techouts.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class MyCartDao {
    public static boolean addCartItem(int userId,int productId,int quantity) {
        Transaction tx = null;
        try {Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            User user = (User) session.get(User.class, userId);
            MyCart myCart =  session.createQuery("from MyCart where user_id=:userId",MyCart.class)
                    .setParameter("userId", userId).uniqueResult();
            double totalPrice = myCart.getTotalPrice();
            for(CartItem item:myCart.getCartItems()){
                if(item.getProduct().getId()==productId){
                    item.setQuantity(item.getQuantity()+quantity);
                    totalPrice = totalPrice + item.getProduct().getPrice();
                    myCart.setTotalPrice(totalPrice);
                    session.merge(item);
                    tx.commit();
                    return true;
                }
            }
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            Product product = ProductDao.getProductById(productId);
            cartItem.setProduct(product);
            cartItem.setMyCart(myCart);
            totalPrice = totalPrice + product.getPrice()*cartItem.getQuantity();
            myCart.setTotalPrice(totalPrice);
            session.persist(cartItem);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
    public static boolean removeCartItem(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            CartItem cartItem = session.get(CartItem.class, id);
            if (cartItem == null) {
                System.out.println("CartItem with id " + id + " not found!");
                return false;
            }
            MyCart myCart = cartItem.getMyCart();
            if (myCart != null) {
                myCart.getCartItems().remove(cartItem);
                double totalPrice = myCart.getTotalPrice();
                totalPrice = totalPrice - cartItem.getProduct().getPrice()*cartItem.getQuantity();
                myCart.setTotalPrice(totalPrice);
            }
            session.delete(cartItem);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
    public static boolean clearCart(int userId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            MyCart myCart = session.createQuery("from MyCart where user.id = :userId", MyCart.class)
                    .setParameter("userId", userId)
                    .uniqueResult();
            if (myCart == null) {
                return false;
            }
            for (CartItem item : myCart.getCartItems()) {
                session.delete(item);
            }
            myCart.getCartItems().clear();
            myCart.setTotalPrice(0);
            session.merge(myCart);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public static MyCart getCartByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from MyCart where user.id = :userId", MyCart.class)
                    .setParameter("userId", user.getId())
                    .uniqueResult();
        }
    }

}
