package com.example.demo.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


import com.example.demo.dto.MedFromQRDTO;
import com.example.demo.dto.PharmaciesEPrescriptionDTO;
import com.example.demo.model.EPrescription;
import com.example.demo.model.MedicinePriceList;
import com.example.demo.model.MedicinePriceListItem;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyStorage;
import com.example.demo.model.Users.Patient;
import com.example.demo.repository.EPrescriptionRepository;
import com.example.demo.repository.MedicinePLItemRepository;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.PharmacyStorageRepository;
import com.example.demo.service.EPrescriptionService;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javassist.NotFoundException;

@Service
public class EPrescriptionServiceImpl implements EPrescriptionService {

    @Autowired
    EPrescriptionRepository ePrescriptionRepository;

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    PharmacyStorageService pharmacyStorageService;

    @Autowired
    MedicinePLItemRepository medicinePLItemRepository;

    @Autowired
    EmailService emailService;
    
    @Autowired
    PharmacyStorageRepository pharmacyStorageRepository;

    public static String decodeQRCode(File qrCodeimage) throws IOException, NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch ( com.google.zxing.NotFoundException n) {
            System.out.println("There is no QR code in the image");
            return null;
        }
    }

    @Override
    public String getEPrescriptionId(String decodedText) {
        String []code = decodedText.split("!");
        return code[0];
    }

    @Override
    public List<MedFromQRDTO> getMedicinesFromQRcode(String decodedText) {
        List<MedFromQRDTO> medicines = new ArrayList<>();
	        if(decodedText.contains(";")) {
	            String []code = decodedText.split("!");
	            String []drugs = code[1].split(";");
	            for (String drug: drugs) {
	                String []drugParts = drug.split("_");
	               
	                medicines.add(new MedFromQRDTO(drugParts[0],drugParts[1],Integer.parseInt(drugParts[2])));
	            }
	        }
	        else {
	            String []code = decodedText.split("!");
	            String []drugParts = code[1].split("_");
	            medicines.add(new MedFromQRDTO(drugParts[0],drugParts[1],Integer.parseInt(drugParts[2])));
	        }
	        return medicines; 
    }

    @Override
    public EPrescription findById(String id) {
        Long i=Long.parseLong(id);
        EPrescription p=ePrescriptionRepository.findById(i).get();
        return p;
    }

    @Override
    public List<PharmaciesEPrescriptionDTO> getPharmaciesForEprecsription(List<MedFromQRDTO> medicines) {

       List<Pharmacy> pharmacies=pharmacyRepository.findAll();
       List<PharmaciesEPrescriptionDTO> p=new ArrayList<>();
       List<MedicinePriceListItem> mpl=medicinePLItemRepository.findAll();

       for(Pharmacy ph:pharmacies){
        int l=0;
        Double totalPrice=0.0;
           for(MedFromQRDTO m:medicines){
               if(pharmacyStorageService.checkAmount(Long.parseLong(m.getMedicineId()), ph.getId(), m.getAmount())){
                    l=l+1;
                    for(MedicinePriceListItem i:mpl){
                        if(i.getMedicinePriceList().getId() ==ph.getMedicinePriceList().getId() && i.getMedicine().getId()==(Long.parseLong(m.getMedicineId()))){
                            totalPrice=totalPrice+ i.getPrice()*m.getAmount();
                        }
                    }
               }
           }
           if(l==medicines.size()){
              PharmaciesEPrescriptionDTO pe=new PharmaciesEPrescriptionDTO();
              pe.setId(ph.getId());
              pe.setName(ph.getName());
              pe.setAddress(ph.getAddress());
              pe.setTotalPrice(totalPrice);
              p.add(pe);
              
           }
       }
        return p;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void buyEprescription(Long pharmacyId, Long prescriptionId) {
        EPrescription e=ePrescriptionRepository.findById(prescriptionId).get();
        e.setPharmacyId(pharmacyId);
        e.setPurchased(true);
        e.setDate(LocalDate.now());

        Patient patient=e.getPatient();

        ePrescriptionRepository.save(e);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(patient.getEmail());
        mailMessage.setSubject("Purchased medicines from ePrescription!");
        mailMessage.setFrom("isatim68@gmail.com");
        mailMessage.setText("Purchased medicines from ePrescription with id: "+e.getId()+". Patient: "+ e.getPatient().getFirstName()+
            " "+e.getPatient().getLastName()+".");

        emailService.sendEmail(mailMessage);

        List<PharmacyStorage> ps=pharmacyStorageRepository.findAll();
        for(MedFromQRDTO m:e.getMedicines()){
            for(PharmacyStorage p:ps){
                if(Long.parseLong(m.getMedicineId())==p.getMedicineId() && p.getPharmacyId()==pharmacyId){
                    p.setInStock(p.getInStock()-m.getAmount());
                    pharmacyStorageRepository.save(p);
                }
            }
        }
    }
    public List<EPrescription> gEPrescriptionByPatient(Long patientId){
       List<EPrescription> ep=ePrescriptionRepository.findAll();
       List<EPrescription> ret=new ArrayList<>();

       for(EPrescription e:ep){
           if(e.getPatient().getId()==patientId){
                ret.add(e);
           }
       }
       return ret;
    }
}
