package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.model.PharmacyStorage;
import com.example.demo.repository.PharmacyStorageRepository;
import com.example.demo.service.IPharmacyStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyStorageService implements IPharmacyStorageService {

    @Autowired
    PharmacyStorageRepository pharmacyStorageRepository;

    @Override
    public Boolean checkAvailability(Long medId, Long phId) {
        System.out.println("provjerava dostupnost");
       PharmacyStorage ret=new PharmacyStorage();
       List<PharmacyStorage> ps=pharmacyStorageRepository.findAll();
       for(PharmacyStorage p:ps){
           if(p.getMedicineId()==medId && p.getPharmacyId()==phId){
               if(p.getInStock()>0){
                   System.out.println("***DOSTUPAN JE**");
                   return true;
               }
           }
       }
        return false;
    }

    @Override
    public void updateStorage(Long medId, Long phId) {
        List<PharmacyStorage> ps=pharmacyStorageRepository.findAll();
        for(PharmacyStorage p:ps){
            if(p.getMedicineId()==medId && p.getPharmacyId()==phId){
               p.setInStock(p.getInStock()-1);
                }
            }
        
    }
    
}
