package com.techouts.dao;

import com.techouts.entities.OrderItem;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techouts.entities.Order;
import com.techouts.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDao {

    public static boolean saveOrder(Order order) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(order);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public static boolean removeOrderById(int orderId) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Order order = session.get(Order.class, orderId);
            tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public static List<Order> getOrders(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery("from Order o where o.user.id = :uid order by o.orderDate desc",
                    Order.class
            ).setParameter("uid", userId);
            List<Order> orders = query.list();
            for (Order o : orders) {
                o.getItems().size();
                for (OrderItem i : o.getItems()) {
                    i.getProduct().getName();
                }
            }
            return orders;
        }
    }

}
