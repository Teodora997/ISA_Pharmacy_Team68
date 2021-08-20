package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ExaminationDTO;
import com.example.demo.dto.PhPriceForMedicineDTO;
import com.example.demo.dto.SearchPharmacyDTO;
import com.example.demo.model.Pharmacy;

public interface IPharmacyService {
    public List<Pharmacy> findAllPharmacies();
    public List<Pharmacy> searchPharmacies(SearchPharmacyDTO searchPharmacyDTO);
    Pharmacy addPharmacy(Pharmacy pharmacy);
    List<Pharmacy> getAvailablePharmacies();
    List<ExaminationDTO> getAvailableExaminations(Long pharmacyId);
    List<PhPriceForMedicineDTO> getPharmaciesForMedicine(String medicineId);
}
