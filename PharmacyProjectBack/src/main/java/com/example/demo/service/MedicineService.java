package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Medicine;


public interface MedicineService {
     List<Medicine> findAllMedicines();
    Medicine addMedicine(MedicineDTO medicine);
    Medicine findById(Long id);
    List<Medicine> addAlternatives(ArrayList<String> alternativesId,String id);
}
