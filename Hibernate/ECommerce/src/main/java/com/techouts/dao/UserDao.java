package com.techouts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techouts.entities.User;
import com.techouts.util.HibernateUtil;

public class UserDao {

    public boolean saveUser(User user) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public User login(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> q = session.createQuery(
                            "from User where username = :username and password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password);
            return q.uniqueResult();
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

    public boolean phoneNumberExists(long phoneNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                    "select count(u.id) from User u where u.phoneNumber = :phone", Long.class);
            query.setParameter("phone", phoneNumber);
            return query.uniqueResult() > 0;
        }
    }

    public boolean usernameExists(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                    "select count(u.id) from User u where u.username = :username", Long.class);
            query.setParameter("username", username);
            return query.uniqueResult() > 0;
        }
    }

    public boolean updateUser(User user) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(user);
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
