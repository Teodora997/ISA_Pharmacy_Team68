package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Users.User;

import org.springframework.stereotype.Service;


public interface SystemAdminService {
    User findById(Long id);
    List<User> findAll();
 
    User save(User u);
    User findByEmail(String mail);
    void remove(User u);
   
}
