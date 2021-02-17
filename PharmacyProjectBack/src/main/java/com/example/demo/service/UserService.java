package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Users.User;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    void verifyUserAccount(String token);
    
    User save(User u);
    User findByEmail(String mail);
    void remove(User u);
}
