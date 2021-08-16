package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.TimeProvider;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.SystemAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminServiceImpl implements SystemAdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private TimeProvider timeProvider;
    
    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User save(User u) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByEmail(String mail) {
        try {
            User user=userRepository.findByEmail(mail);
            return user;
        } catch (NoSuchElementException e) {
          throw new NoSuchElementException("User with email "+mail+" does not exist.");
        }
    }

    @Override
    public void remove(User u) {
        // TODO Auto-generated method stub
        
    }

   
    
}
