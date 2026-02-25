package com.techouts.repositoryimplementation;

import com.techouts.entity.User;
import com.techouts.repository.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImplementation implements UserRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        try {
            em.persist(user);
        } catch (Exception e) {
        }
    }
    @Override
    public User findUserById(int id) {
        return em.find(User.class, id);
    }
    @Override
    public User findUserByUsername(String username) {
        List<User> users = em.createQuery("From User where username=:username", User.class)
                .setParameter("username", username).getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
    @Override
    public User findUserByEmail(String email) {
        List<User> users = em.createQuery("From User where email=:email", User.class)
                .setParameter("email", email).getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
    @Override
    public boolean usernameExists(String username,int userId) {
        List<User> users = em.createQuery("Select u from User u where username=:username and u.id<>:uid", User.class)
                .setParameter("username", username)
                .setParameter("uid",userId)
                .getResultList();
        return users.isEmpty();
    }
    @Override
    public boolean emailExists(String email,int userId) {
        List<User> users = em.createQuery("Select u from User u where email=:email and u.id<>:uid", User.class)
                .setParameter("uid",userId)
                .setParameter("email", email).getResultList();
        return users.isEmpty();
    }
    @Override
    public User loadUserByUsername(String username) {
        List<User> users = em.createQuery("Select u from User u where username=:username", User.class)
                .setParameter("username", username)
                .getResultList();
        return users.isEmpty()?null: users.get(0);
    }

}
