package com.techouts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techouts.entities.Order;
import com.techouts.util.HibernateUtil;

public class OrderDao {

    public static boolean saveOrder(Order order) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(order);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
