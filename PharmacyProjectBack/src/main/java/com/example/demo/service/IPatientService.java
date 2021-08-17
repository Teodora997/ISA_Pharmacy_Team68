package com.example.demo.service;

import java.util.Set;

import com.example.demo.model.Medicine;

public interface IPatientService {
    public Set<Medicine> getMyAllergies(String id);
}
