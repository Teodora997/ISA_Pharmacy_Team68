package com.example.demo.controller;

import com.example.demo.TimeProvider;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Roles;
import com.example.demo.dto.RequestForRegDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.RequestForReg;
import com.example.demo.model.Users.ConfirmationToken;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.RequestForRegService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/users")
public class UserController {
	
	
    @Autowired
    private UserServiceImpl userServiceImpl;

	@Autowired UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private TimeProvider timeProvider;

    @Autowired
	private UserRepository  userRepository;
	
	@Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

	

    @GetMapping("/public/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        User user=userServiceImpl.findById(id);
        return new ResponseEntity<>(new UserDTO(user),HttpStatus.OK);
    }

	

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) {

	
        User user = userService.registerUser(newUser);
        if(user != null) {

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("User with email is already registered", HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    
}
