package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ComplaintDTO;
import com.example.demo.model.Complaint;
import com.example.demo.model.Users.User;

import org.springframework.stereotype.Service;


public interface SystemAdminService {
    User findById(Long id);
    List<User> findAll();
 
    User save(User u);
    User findByEmail(String mail);
    void remove(User u);
    List<ComplaintDTO> getComplaints();
    Complaint replyComplaint(Long id);
   
}
