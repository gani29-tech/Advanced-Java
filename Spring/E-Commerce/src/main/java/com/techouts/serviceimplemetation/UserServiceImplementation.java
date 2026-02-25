package com.techouts.serviceimplemetation;

import com.techouts.config.SecurityConfig;
import com.techouts.entity.User;
import com.techouts.repository.UserRepo;
import com.techouts.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImplementation implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImplementation(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.saveUser(user);
    }


    @Override
    @Transactional
    public void updateUser(User user, User currentUser) {
        if (currentUser == null) return;
        if(userRepo.emailExists(user.getEmail(),user.getId())){
            throw new UsernameNotFoundException("Email Already Exists");
        }
        if(userRepo.usernameExists(user.getUsername(),user.getId())){
            throw new UsernameNotFoundException("Username Already Exists");
        }
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        currentUser.setAddress(user.getAddress());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.loadUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return user;
    }
}
