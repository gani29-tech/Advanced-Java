package com.techouts.dao;

import com.techouts.entities.MyCart;
import com.techouts.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MyCartDao {
    public static boolean
    addCartItem(MyCart myCart) {
        Transaction tx = null;
        try {Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(myCart);
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
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            MyCart myCart = session.get(MyCart.class, id);
            myCart.getCartItems().remove(myCart);
            session.delete(myCart);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
