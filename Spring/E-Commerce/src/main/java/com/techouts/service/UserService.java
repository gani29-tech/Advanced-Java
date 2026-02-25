package com.techouts.service;
import com.techouts.entity.User;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user, User currentUser);
}
