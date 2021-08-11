package com.example.demo.controller;

import com.example.demo.TimeProvider;
import com.example.demo.Roles;
import com.example.demo.dto.RequestForRegDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.RequestForReg;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.AuthorityRepository;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private TimeProvider timeProvider;

    @Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private RequestForRegService requestForRegService;

	

    @GetMapping("/public/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        User user=userServiceImpl.findById(id);
        return new ResponseEntity<>(new UserDTO(user),HttpStatus.OK);
    }

	

    @PostMapping("/public/addUser")
    public ResponseEntity<RequestForRegDTO> createRequest (@RequestBody RequestForRegDTO requestreg) throws Exception{

		System.out.println("AAAAAAAAAA");
		System.out.println(requestreg.getId());
        if (userRepository.findByEmail(requestreg.getUserData().getEmail()) != null) {
			throw new Exception("Email '" + requestreg.getUserData().getEmail() + "' already exists.");
		}
		if (!requestreg.getUserData().getPassword().equals(requestreg.getUserData().getPassword1())) {
			throw new Exception("Provided passwords must be the same.");
		}
		
		System.out.println("BBBBBBBBBB");
		System.out.println(requestreg.getUserData().getEmail());

		User user=new User();
		user.setId(requestreg.getUserData().getId());
		user.setLastName(requestreg.getUserData().getLastName());
		user.setFirstName(requestreg.getUserData().getFirstName());
		user.setAddress(requestreg.getUserData().getAddress());
		user.setCity(requestreg.getUserData().getCity());
		user.setEmail(requestreg.getUserData().getEmail());
		user.setTelephone(requestreg.getUserData().getTelephone());
		user.setPassword(passwordEncoder.encode(requestreg.getUserData().getPassword()));
		user.setRole(Roles.ROLE_PATIENT);
		user.getAuthorities().add(authorityRepository.findByName(Roles.ROLE_PATIENT));

		user = userServiceImpl.save(user);

		System.out.println(user.getEmail());

		RequestForReg req = new RequestForReg(user);
		req = requestForRegService.save(req);

		System.out.println("CCCCCCCCCC");
		System.out.println(req.getId());
		
		return new ResponseEntity<>(new RequestForRegDTO(req), HttpStatus.CREATED);
    }

    
}
