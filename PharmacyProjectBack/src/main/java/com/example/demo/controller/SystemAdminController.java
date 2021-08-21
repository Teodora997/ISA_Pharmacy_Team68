package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.LoyaltyProgram;
import com.example.demo.model.Users.ConfirmationToken;
import com.example.demo.model.Users.User;
import com.example.demo.repository.LoyaltyProgramRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.service.SystemAdminService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/systemAdmin")
public class SystemAdminController {
    
    @Autowired
    SystemAdminService systemAdminService;

    @Autowired
    UserService userService;

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;

    @PostMapping(value = "/addLoyaltyProgram")
    public ResponseEntity<LoyaltyProgram> addLoyaltyProgram(@RequestBody LoyaltyProgram program){
        List<LoyaltyProgram> programs=loyaltyProgramRepository.findAll();
        if(programs.isEmpty()==false){
            loyaltyProgramRepository.deleteAll();
        }
       loyaltyProgramRepository.save(program);
        return new ResponseEntity<>(program,HttpStatus.OK);
    }
   
}
