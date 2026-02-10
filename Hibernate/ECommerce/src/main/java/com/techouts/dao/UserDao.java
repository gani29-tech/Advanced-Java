package com.techouts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techouts.entities.User;
import com.techouts.util.HibernateUtil;

public class UserDao {

    public boolean saveUser(User user) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long q= session.createQuery(
                    "SELECT COUNT(id) from User where username = :username and password = :password", Long.class)
            .setParameter("username", username)
            .setParameter("password", password).uniqueResult();
            System.out.println(q);
            return q>0;
        }
    }


    public boolean emailExists(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                "select count(u.id) from User u where u.email = :email", Long.class);
            query.setParameter("email", email);
            return query.uniqueResult() > 0;
        }
    }
}
