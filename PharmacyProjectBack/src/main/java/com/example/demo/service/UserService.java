package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Users.Dermatologist;
import com.example.demo.model.Users.PharmacyAdmin;
import com.example.demo.model.Users.Supplier;
import com.example.demo.model.Users.User;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    void verifyUserAccount(String token);
    
    User save(User u);
    User findByEmail(String mail);
    void remove(User u);
    User registerUser(User user);
    Dermatologist registerDermatologist(User user);
    Supplier registerSupplier(User user);
    PharmacyAdmin registerPharmacyAdmin(User user);
}
