package com.techouts.repository;

import com.techouts.entity.User;

public interface UserRepo {
    void saveUser(User user);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    boolean usernameExists(String username,int id);
    boolean emailExists(String email,int id);
    User findUserById(int id);
    User loadUserByUsername(String username);
}
