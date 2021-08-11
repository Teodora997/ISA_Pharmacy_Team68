package com.example.demo.controller;

import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.service.RequestForRegService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.dto.RequestForRegDTO;
import com.example.demo.model.RequestForReg;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="api/requestForReg")
public class RequestForRegController {
    
    private RequestForRegService requestForRegService;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    public RequestForRegController (RequestForRegService requestForRegService){
        this.requestForRegService=requestForRegService;
    }
    
    @PostMapping()
    public ResponseEntity<RequestForRegDTO> createReqForReg(@RequestBody RequestForRegDTO reqDTO){
        RequestForReg req=requestForRegService.createReqForReg(reqDTO);
        return new ResponseEntity<>(new RequestForRegDTO(req),HttpStatus.CREATED);
    }
}
