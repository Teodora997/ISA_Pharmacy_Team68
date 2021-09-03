package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import com.example.demo.dto.AvailabiltyInPhEPrescriptionDTO;
import com.example.demo.dto.MedFromQRDTO;
import com.example.demo.dto.PharmaciesEPrescriptionDTO;
import com.example.demo.model.EPrescription;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.repository.EPrescriptionRepository;
import com.example.demo.repository.MedFromQRRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.service.EPrescriptionService;
import com.example.demo.service.impl.EPrescriptionServiceImpl;
import com.example.demo.service.impl.PatientService;
import com.google.zxing.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/eprescription")
public class EPrescriptionController { 

    @Autowired
	EPrescriptionService ePrescriptionService;

    @Autowired
    EPrescriptionServiceImpl ePrescriptionServiceImpl;

	@Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EPrescriptionRepository ePrescriptionRepository;

    @Autowired
    MedFromQRRepository medFromQRRepository;
	
	@PostMapping("/getEprescription/{userId}")
    public ResponseEntity<?> searchDrugsBasedOnQRCode(@PathVariable("userId") String userId ,@RequestParam("file") MultipartFile file) throws IOException, NotFoundException, javassist.NotFoundException {
        
        EPrescription ep=new EPrescription();
        

        if (!file.isEmpty()) {
            try {
                BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
                File destination = new File("src/main/resources/QR/" + file.getOriginalFilename());
                ImageIO.write(src, "png", destination);
                String decodedText = EPrescriptionServiceImpl.decodeQRCode(new File("src/main/resources/QR/" + file.getOriginalFilename()));
                System.out.println("U KONTROLER EPRESCRIPTION FILE: "+ file.getOriginalFilename());
                System.out.println("TEXT QR KODA: "+ decodedText);
                if (decodedText == null) {
                    throw new IllegalArgumentException("Please upload valid QR code!");
                } else {
                    String code = ePrescriptionService.getEPrescriptionId(decodedText);
                    System.out.println("ID EPRESCRIPTION : "+code);
                    
                    List<MedFromQRDTO> medicines= ePrescriptionService.getMedicinesFromQRcode(decodedText);
                    
                   

                if(ePrescriptionRepository.findById(Long.parseLong(code)).orElse(null) ==null){
                for(MedFromQRDTO med:medicines){
                    medFromQRRepository.save(med);
                }
            }


                    List<PharmaciesEPrescriptionDTO> pharmacies=ePrescriptionService.getPharmaciesForEprecsription(medicines);

                    AvailabiltyInPhEPrescriptionDTO e=new AvailabiltyInPhEPrescriptionDTO(Long.parseLong(code),medicines,pharmacies);

                 if(ePrescriptionRepository.findById(Long.parseLong(code)).orElse(null) ==null){
                    ep.setId(Long.parseLong(code));

                    ep.setPatient(patientRepository.findById(Long.parseLong(userId)).get());
                    ep.setPurchased(false);
                    ep.setMedicines(medicines);

                    ePrescriptionRepository.save(ep);
                 }

                   return new ResponseEntity<>(e,HttpStatus.OK);
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Please upload valid QR code!");}
        }
        throw new IllegalArgumentException("Please upload valid QR code!");
    }
	
    @PostMapping("/buyEprescription/{pharmacyId}")
    public int buyEprescription(@PathVariable("pharmacyId") Long pharmacyId ,@RequestBody Long prescriptionId)  {
        EPrescription e=ePrescriptionRepository.findById(prescriptionId).get();
        Set<Medicine> allergies=patientService.getMyAllergies(String.valueOf(e.getPatient().getId()));

        for(Medicine a:allergies){
            for(MedFromQRDTO med:e.getMedicines()){
                if(a.getId()==Long.parseLong(med.getMedicineId())){
                    return 1;
                }
            }
        }

        if(e.isPurchased()==false){
        ePrescriptionService.buyEprescription(pharmacyId,prescriptionId);
        return 2;
        }else{
           return 0;
        }
    }
}
