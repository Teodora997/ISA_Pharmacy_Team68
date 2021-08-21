package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.TimeProvider;
import com.example.demo.dto.ComplaintDTO;
import com.example.demo.model.Complaint;
import com.example.demo.model.Users.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.SystemAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminServiceImpl implements SystemAdminService {

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

    @Autowired
    private ComplaintRepository complaintRepository;
    
    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User save(User u) {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ComplaintDTO> getComplaints() {
       List<Complaint> complaints=complaintRepository.findAll();
       List<ComplaintDTO> c=new ArrayList<ComplaintDTO>();
       
       for(Complaint c1:complaints){
            if(c1.getIsAnswered()==false){
                
                ComplaintDTO dto=new ComplaintDTO();
                dto.setId(c1.getId());
                dto.setDate(c1.getDate());
                dto.setEmail(c1.getPatient().getEmail());
                dto.setName(c1.getName());
                dto.setPatientId(c1.getPatient().getId());
                dto.setText(c1.getText());
                c.add(dto);
            }
       }


        return c;
    }

    @Override
    public Complaint replyComplaint(Long id) {
       
       Complaint c=complaintRepository.findById(id).get();
       c.setIsAnswered(true);
       
       complaintRepository.save(c);

       return c;
    }

   
    
}
