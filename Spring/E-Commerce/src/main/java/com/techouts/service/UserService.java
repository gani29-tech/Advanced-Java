package com.techouts.service;

import com.techouts.entity.User;

public interface UserService {
    User getUserById(Long id);
    void updateUser(User user);
    void saveUser(User user);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}