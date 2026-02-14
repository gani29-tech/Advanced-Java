package com.techouts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.techouts.entities.Product;
import com.techouts.util.HibernateUtil;

public class ProductDao {
    public static void saveProduct(Product product) {
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

    public static Product getProductByName(String productName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Product where name = :name", Product.class)
                    .setParameter("name", productName).uniqueResult();
        }
    }

    public static Product getProductById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }

    public static List<Product> getProductsByCategory(String category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (category.equals("All")) {
                List<Product> products = session.createQuery("from Product").list();
                return products;
            } else {
                return session.createQuery("from Product where category = :category", Product.class)
                        .setParameter("category", category).list();
            }
        }
    }

    public static List<String> getAllCategories() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT DISTINCT p.category FROM Product p", String.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public static List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("from Product", Product.class);
            return query.list();
        }
    }

    public static boolean updateProduct(Product product) {
        Transaction tx = null;
        boolean flag = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Product existingProduct = session.createQuery("from Product where name=:name", Product.class).setParameter("name", product.getName()).uniqueResult();
            if (existingProduct != null) {
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

    public static int deleteProduct(Product product) {
        Transaction tx = null;
        int rows = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.createQuery("delete from CartItem where product_id=:id").setParameter("id", product.getId()).executeUpdate();
            session.createQuery("delete from OrderItem where product_id=:id").setParameter("id", product.getId()).executeUpdate();
            rows = session.createQuery("delete from Product where name=:name").setParameter("name", product.getName()).executeUpdate();
            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return rows;
    }

    public static String getImageName(int productId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product product = session.get(Product.class, productId);
            return product.getImageUrl();
        }
    }
}
