package com.example.demo.controller;

import com.example.demo.TimeProvider;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private TimeProvider timeProvider;

    @Autowired
    private UserRepository  userRepository;

    @GetMapping("/public/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        User user=userServiceImpl.findById(id);
        return new ResponseEntity<>(new UserDTO(user),HttpStatus.OK);
    }

    
}
