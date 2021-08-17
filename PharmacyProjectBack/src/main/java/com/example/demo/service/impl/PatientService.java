package com.example.demo.service.impl;

import java.util.Set;

import com.example.demo.model.Medicine;
import com.example.demo.model.Users.Patient;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.service.IPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private PatientRepository patientRepository;
    
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Set<Medicine> getMyAllergies(String id) {
        Patient p=patientRepository.findById(Long.parseLong(id)).get();

        return p.getAllergies();
    }
    
}
