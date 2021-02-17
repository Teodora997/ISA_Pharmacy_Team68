package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.TimeProvider;
import com.example.demo.model.Users.ConfirmationToken;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

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
        try {
            User user=userRepository.findById(id).get();
            return user;
        } catch (NoSuchElementException e) {
           throw new NoSuchElementException("User with Id "+id+" does not exist") ;
        }
      
    }

    @Override
    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }


    @Override
    public void verifyUserAccount(String token)  {
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByToken(token);

        if (confirmationToken == null) {
            throw new NoSuchElementException("Requested token doesn't exist.");
        }

        User user = confirmationToken.getUser();
        Date now = timeProvider.now();
        long timeDifference = now.getTime() - confirmationToken.getCreatedDateTime().getTime();
        long timeDifferenceMinutes = timeDifference / (60 * 1000);

        if (timeDifferenceMinutes < 15) {
            user.setIsActivated(true);
            userRepository.save(user);
        } else {
            confirmationTokenRepository.delete(confirmationToken);
            userRepository.delete(user);
            throw new NoSuchElementException ("Confirmation token timed out.");
        }
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
      
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
        userRepository.delete(u);
    }

}
