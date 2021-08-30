package com.example.demo.service;

import com.example.demo.model.DermaObj;
import com.example.demo.model.Examination;
import com.example.demo.model.Users.Dermatologist;

import java.util.List;

public interface IDermatologistService {

    public List<Dermatologist> getAllDermatologists();
    public DermaObj getDermatologist(String name, String surname);
    public List<Examination> getExaminations();
}
