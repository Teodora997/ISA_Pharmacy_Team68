package com.example.demo.service;

import com.example.demo.repository.PharmacyRepository;

import java.util.List;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {
    @Autowired
    PharmacyRepository pharmacyRepository;

    public List<Pharmacy> findAllPharmacies(){
        return pharmacyRepository.findAll();
    }
}
