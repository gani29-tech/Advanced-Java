package com.techouts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techouts.entities.Product;
import com.techouts.util.HibernateUtil;



public class ProductDao {


    public void saveProduct(Product product) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public static boolean getProductByName(String productName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product product = session.createQuery("from Product where name = :name", Product.class)
                    .setParameter("name", productName).uniqueResult();
            return product != null;
        }
    }
    public static Product getProductById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }

    public static List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("from Product", Product.class);
            return query.list();
        }
    }

    public boolean updateProduct(Product product) {
        Transaction tx = null;
        boolean flag = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Product existingProduct = session.createQuery("from Product where name=:name",Product.class).setParameter("name", product.getName()).uniqueResult();
            if(existingProduct != null){
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setImageUrl(product.getImageUrl());
                flag = true;
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return flag;
    }

    public int deleteProduct(String productName) {
        Transaction tx = null;
        int rows = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            rows = session.createQuery("delete from Product where name=:name").setParameter("name", productName).executeUpdate();
            tx.commit();
            session.close();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return rows;
    }
}
