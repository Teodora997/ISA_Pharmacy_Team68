package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.ComplaintDTO;
import com.example.demo.model.Complaint;
import com.example.demo.model.LoyaltyProgram;
import com.example.demo.repository.LoyaltyProgramRepository;
import com.example.demo.service.SystemAdminService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/addLoyaltyProgram")
    public ResponseEntity<LoyaltyProgram> addLoyaltyProgram(@RequestBody LoyaltyProgram program){
        List<LoyaltyProgram> programs=loyaltyProgramRepository.findAll();
        if(programs.isEmpty()==false){
            loyaltyProgramRepository.deleteAll();
        }
       loyaltyProgramRepository.save(program);
        return new ResponseEntity<>(program,HttpStatus.OK);
    }

    @GetMapping(value = "/getComplaints")
    public ResponseEntity<List<ComplaintDTO>> getComplaints(){
        List<ComplaintDTO> complaints=systemAdminService.getComplaints();
        return new ResponseEntity<>(complaints,HttpStatus.OK);
    }

     @PostMapping(value = "/replyComplaint/{cId}")
    public ResponseEntity replyComplaint(@PathVariable("cId") Long cId ,@RequestBody String reply){
        
        Complaint c=systemAdminService.replyComplaint(cId);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(c.getPatient().getEmail());
        mailMessage.setSubject("Complaint Answer");
        mailMessage.setFrom("isatim68@gmail.com");
        mailMessage.setText("Your complaint for: " + c.getName()
                + "\nText: "+ c.getText() + ". \n System administrator answer: " + reply);

        emailService.sendEmail(mailMessage);

        return new ResponseEntity(HttpStatus.OK);
    }
   
}
