package org.techouts.repository;

import org.springframework.stereotype.Repository;
import org.techouts.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepo {
    @PersistenceContext
    private EntityManager em;
    public List<User> findAll() {
        return em.createQuery("from User", User.class).getResultList();
    }
    public  User findById(int id) {
        return em.find(User.class, id);
    }
    @Transactional
    public User save(User user) {
        em.persist(user);
        return user;
    }
    @Transactional
    public User delete(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
        return user;
    }
    @Transactional
    public User update(int id,User user) {
        User u = em.find(User.class, id);
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
        em.merge(u);
        return u;
    }
}

