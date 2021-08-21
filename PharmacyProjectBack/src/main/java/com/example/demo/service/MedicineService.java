package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineReservation;


public interface MedicineService {
     List<Medicine> findAllMedicines();
    Medicine addMedicine(MedicineDTO medicine);
    Medicine findById(Long id);
    List<Medicine> addAlternatives(ArrayList<String> alternativesId,String id);
    List<Medicine> searchMedicines(String name);
    List<MedicineDTO> filterMedicines(List<MedicineDTO> medicines,String type);
    MedicineReservationDTO makeReservation(MedicineReservationDTO med,String patientId);
    List<MedicineReservationDTO> getReservationsByPatient(Long patientId);
    MedicineReservation cancelReservation(MedicineReservationDTO med);
}
