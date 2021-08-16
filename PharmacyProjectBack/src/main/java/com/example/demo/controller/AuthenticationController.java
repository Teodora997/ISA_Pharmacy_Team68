package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.security.TokenUtils;
import com.example.demo.security.auth.JwtAuthenticationRequest;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth",produces = MediaType.APPLICATION_JSON_VALUE )

public class AuthenticationController {
    
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                         HttpServletResponse response) throws AuthenticationException, IOException {
        

        
        return new ResponseEntity<>(userDetailsService.login(authenticationRequest),HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return ResponseEntity.status(200).build();
    }

    @PostMapping(value = "/getLoggedUser")
    public ResponseEntity<UserDTO> getLoggedUser(@RequestBody String id) {
        System.out.println("UZIMA LOGOVANOG "+id);
        User user=userService.findById(Long.parseLong(id));
      System.out.println("Nasao usera "+ user.getFirstName());
        return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
    }
    // @PostMapping("/change-password")
    // public ResponseEntity changePassword(@RequestBody PasswordChanger passwordChanger) {
    //     userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword, passwordChanger.email);

    //     Map<String, String> result = new HashMap<>();
    //     result.put("result", "success");
    //     return ResponseEntity.accepted().body(result);
    // }



    static class PasswordChanger {
        public String oldPassword;
        public String newPassword;
        public String email;
    }

    // @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    // public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {

    //     String token = tokenUtils.getToken(request);
    //     String username = this.tokenUtils.getMailFromToken(token);
    //     User user = (User) this.userDetailsService.loadUserByUsername(username);

    //     if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
    //         String refreshedToken = tokenUtils.refreshToken(token);
    //         int expiresIn = tokenUtils.getExpiredIn();

    //         return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
    //     } else {
    //         UserTokenState userTokenState = new UserTokenState();
    //         return ResponseEntity.badRequest().body(userTokenState);
    //     }
    // }
}
