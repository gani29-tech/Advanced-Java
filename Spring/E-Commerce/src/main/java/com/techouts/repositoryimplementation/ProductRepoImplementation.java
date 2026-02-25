package com.techouts.repositoryimplementation;

import com.techouts.entity.Product;
import com.techouts.repository.ProductRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepoImplementation implements ProductRepo {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void addProduct(Product product) {
        try{
            em.persist(product);
        }catch (Exception e){
        }
    }
    @Override
    public Product getProductById(int id) {
        return em.find(Product.class,id);
    }
    @Override
    public void deleteProduct(String name) {
        try {
            Product product = em.createQuery("from Product p where p.name = :name", Product.class)
                    .setParameter("name", name)
                    .getSingleResult();
            em.remove(product);
        }catch (Exception e){
        }
    }

    @Override
    public Product getProductByName(String name) {
        return em.createQuery("From Product p where p.name=:name", Product.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Product> getAllProducts() {
        return  em.createQuery("From Product", Product.class).getResultList();
    }

    @Override
    public boolean productExists(String name,int id) {
        List<Product> products =em.createQuery("from Product p where p.name=:name and p.id<>:id",Product.class)
                .setParameter("name",name)
                .setParameter("id",id).getResultList();
        return !products.isEmpty();
    }
}
