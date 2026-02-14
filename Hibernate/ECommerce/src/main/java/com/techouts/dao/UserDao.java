package com.techouts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techouts.entities.User;
import com.techouts.util.HibernateUtil;

public class UserDao {

    public static boolean saveUser(User user) {
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

    public static User login(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> q = session.createQuery(
                            "from User where username = :username and password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password);
            return q.uniqueResult();
        }
    }


    public static Long emailExists(String email, int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                    "select count(u.id) from User u"
                            + " where u.email = :email and u.id <> :uid", Long.class);
            query.setParameter("email", email);
            query.setParameter("uid", userId);
            return query.uniqueResult();
        }
    }

    public static Long phoneNumberExists(long phoneNumber, int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                    "select count(u.id) from User u"
                            + " where u.phoneNumber = :phoneNumber and u.id <> :uid", Long.class);
            query.setParameter("phoneNumber", phoneNumber);
            query.setParameter("uid", userId);
            return query.uniqueResult();
        }
    }

    public static Long usernameExists(String username, int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                    "select count(u.id) from User u"
                            + " where u.username = :username and u.id <> :uid", Long.class);
            query.setParameter("username", username);
            query.setParameter("uid", userId);
            return query.uniqueResult();
        }
    }


    public static boolean updateUser(User user) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(user);
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
