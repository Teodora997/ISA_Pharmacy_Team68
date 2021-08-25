package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MedFromQRDTO;
import com.example.demo.dto.PharmaciesEPrescriptionDTO;
import com.example.demo.model.EPrescription;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Users.Patient;

public interface EPrescriptionService {
    EPrescription findById(String id);
    String getEPrescriptionId(String decodedText);
	List<MedFromQRDTO> getMedicinesFromQRcode(String decodedText);
   List<PharmaciesEPrescriptionDTO> getPharmaciesForEprecsription(List<MedFromQRDTO> medicines);
   void buyEprescription(Long pharmacyId,Long prescriptionId);
   

}
