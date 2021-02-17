package com.example.demo.service.impl;

import java.util.NoSuchElementException;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Users.User;
import com.example.demo.model.Users.UserTokenState;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.security.TokenUtils;
import com.example.demo.security.auth.JwtAuthenticationRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserServiceImpl userService;


    /* Return User from database */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //User user = userRepository.findByUsername(username);
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {
            
            return user;
            
        }
    }

    /* Change User's password */
    public void
    changePassword(String oldPassword, String newPassword, String email) {
        User user2 = userService.findByEmail(email);
        String mail = user2.getEmail();

        if (authenticationManager != null) {
            LOGGER.debug("Re-authenticating user '" + mail + "' for password change request.");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mail, oldPassword));
        } else {
            LOGGER.debug("No authentication manager set. can't change Password!");
            return;
        }

        LOGGER.debug("Changing password for user '" + mail + "'");

        User user = (User) loadUserByUsername(mail);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public UserDTO login(JwtAuthenticationRequest authenticationRequest) {

       

        Authentication authentication;



        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()));
                            

            
        } catch (BadCredentialsException e) {
            throw new NoSuchElementException  ("Credentials are not valid!");
        }

        

        // Insert username and password into context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Create token
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        

        UserDTO userDto = new UserDTO(user);
        userDto.setToken(new UserTokenState(jwt, expiresIn));

        return userDto;
    }

    // public UserTokenState refreshAuthenticationToken(HttpServletRequest request) {
    //     String token = tokenUtils.getToken(request);
    //     String username = tokenUtils.getMailFromToken(token);
    //     User user = (User) loadUserByUsername(username);

    //     if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
    //         String refreshedToken = tokenUtils.refreshToken(token);
    //         int expiresIn = tokenUtils.getExpiredIn();
    //         return new UserTokenState(refreshedToken, expiresIn);
    //     } else {
    //         throw new ApiRequestException("Token can not be refreshed.");
    //     }
    // }
    
}
