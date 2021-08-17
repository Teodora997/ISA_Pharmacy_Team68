package com.example.demo.service.impl;

import java.util.Set;

import com.example.demo.model.Examination;
import com.example.demo.model.ExaminationStatus;
import com.example.demo.model.Medicine;
import com.example.demo.model.Users.Patient;
import com.example.demo.repository.ExaminationRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.service.IPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private ExaminationRepository examinationRepository;

    
    public PatientService(PatientRepository patientRepository, ExaminationRepository examinationRepository) {
        this.patientRepository = patientRepository;
        this.examinationRepository = examinationRepository;
    }

    @Override
    public Set<Medicine> getMyAllergies(String id) {
        Patient p=patientRepository.findById(Long.parseLong(id)).get();

        return p.getAllergies();
    }

    @Override
    public Long makeExamination(String patientId, Long examinationId) {
        Examination examination=examinationRepository.findById(examinationId).get();
        examination.setStatus(ExaminationStatus.scheduled);
        Patient patient=patientRepository.findById(Long.parseLong(patientId)).get();
        examination.setPatient(patient);
        examinationRepository.save(examination);
        return examinationId;
    }
    
}
