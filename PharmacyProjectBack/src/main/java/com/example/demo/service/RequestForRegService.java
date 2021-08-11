package com.example.demo.service;

import com.example.demo.model.RequestForReg;
import com.example.demo.dto.RequestForRegDTO;
import com.example.demo.repository.RequestForRegRepository;
import com.example.demo.repository.UserRepository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestForRegService {
    
    private RequestForRegRepository requestForRegRepository;

    private UserRepository userRepository;

    @Autowired
    public RequestForRegService(RequestForRegRepository requestForRegRepository) {
        this.requestForRegRepository = requestForRegRepository;
    }

    public RequestForReg save(RequestForReg requestForReg) {
        return requestForRegRepository.save(requestForReg);
    }

    public RequestForReg findOne(Long id){
        return requestForRegRepository.findById(id).orElseGet(null);
    }

    public RequestForReg createReqForReg(RequestForRegDTO reqDTO) {

        RequestForReg req = new RequestForReg();
        req.setId(reqDTO.getId());
        req.setAccepted(reqDTO.isAccepted());
        req.setUserData(req.getUserData());
        req = this.save(req);
        return req;
    }

}
