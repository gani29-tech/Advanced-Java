package org.techouts.service;

import org.springframework.stereotype.Service;
import org.techouts.model.User;
import org.techouts.repository.UserRepo;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User save(User user) {
        return userRepo.save(user);
    }
    public User findById(int id) {
        return userRepo.findById(id);
    }
    public User update(int id, User user) {
        return userRepo.update(id,user);
    }
    public User delete(int id) {
        return userRepo.delete(id);
    }
}
