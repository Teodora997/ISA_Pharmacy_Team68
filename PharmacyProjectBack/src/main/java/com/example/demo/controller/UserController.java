package com.example.demo.controller;

import com.example.demo.TimeProvider;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Roles;
import com.example.demo.dto.RequestForRegDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserForEditDTO;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.RequestForReg;
import com.example.demo.model.Users.ConfirmationToken;
import com.example.demo.model.Users.Dermatologist;
import com.example.demo.model.Users.PharmacyAdmin;
import com.example.demo.model.Users.Supplier;
import com.example.demo.model.Users.SystemAdmin;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.RequestForRegService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.EmailService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    EmailService emailService;
	
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

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Account verification");
            mailMessage.setFrom("isatim68@gmail.com");
            mailMessage.setText("<a href='http://localhost:4200/login'>Click on this to go to your account. </a>"
           );
    
            emailService.sendEmail(mailMessage);

            confirmationTokenRepository.save(confirmationToken);

            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }
    @PostMapping("/registerDermatologist")
    public ResponseEntity<?> registerDermatologist(@RequestBody User newUser) {

        
        Dermatologist user = userService.registerDermatologist(newUser);
        User u=new User(user.getId(),user.getFirstName(),user.getLastName(),user.getPassword(), user.getAddress(),user.getCity(),user.getEmail(),user.getTelephone());
        u.setFirstTimeLogin(true);
        if(user != null) {

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            return new ResponseEntity<User>(u, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }
    }
    
    @PostMapping("/registerSupplier")
    public ResponseEntity<?> registerSupplier(@RequestBody User newUser) {

        
        Supplier user = userService.registerSupplier(newUser);
        User u=new User(user.getId(),user.getFirstName(),user.getLastName(),user.getPassword(), user.getAddress(),user.getCity(),user.getEmail(),user.getTelephone());
        u.setFirstTimeLogin(true);
        if(user != null) {

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            return new ResponseEntity<User>(u, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }
    }

    @PostMapping("/registerPharmacyAdmin")
    public ResponseEntity<?> registerPharmacyAdmin(@RequestBody User newUser) {

        
        PharmacyAdmin user = userService.registerPharmacyAdmin(newUser);
        User u=new User(user.getId(),user.getFirstName(),user.getLastName(),user.getPassword(), user.getAddress(),user.getCity(),user.getEmail(),user.getTelephone());
        u.setFirstTimeLogin(true);
        if(user != null) {

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            return new ResponseEntity<User>(u, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }
    }

    @PostMapping(value="/addPharmacyForAdmin/{id}")
    public ResponseEntity<?> addPharmacyForAdmin(@RequestBody String pharmacyId, @PathVariable("id") String id){
    
        Pharmacy pharmacy=userService.addPharmacyForAdmin(pharmacyId, id);

        return new ResponseEntity<String>(pharmacyId, HttpStatus.CREATED);
    }


    @PostMapping("/registerSystemAdmin")
    public ResponseEntity<?> registerSystemAdmin(@RequestBody User newUser) {

        
        SystemAdmin user = userService.registerSystemAdmin(newUser);
        User u=new User(user.getId(),user.getFirstName(),user.getLastName(),user.getPassword(), user.getAddress(),user.getCity(),user.getEmail(),user.getTelephone());
        u.setFirstTimeLogin(true);
        if(user != null) {

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            return new ResponseEntity<User>(u, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/editProfile")
    public ResponseEntity updateUser(@RequestBody UserForEditDTO editedUser) {
        System.out.println("Usao u kontroler za izmjenu  "+editedUser.getFirstName());
        userService.editProfile(editedUser);
        return new ResponseEntity<>("Profile updated!",HttpStatus.OK);
    }

    @GetMapping( value = "/getUserId")
    public ResponseEntity getUserId( String userId)
    {
       // int retVal = u.getId().intValue();
        //int retVal = Integer.parseInt(userId);



        int retVal = Integer.parseInt(userId, 10);



        return new ResponseEntity<>(retVal, HttpStatus.OK);

    }

}
