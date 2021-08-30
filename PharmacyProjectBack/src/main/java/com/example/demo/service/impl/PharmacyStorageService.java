package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.PharmacyStorageDTO;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyStorage;
import com.example.demo.repository.PharmacyStorageRepository;
import com.example.demo.service.IPharmacyStorageService;

import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class PharmacyStorageService implements IPharmacyStorageService {

    @Autowired
    PharmacyStorageRepository pharmacyStorageRepository;
    @Autowired
    PharmacyService pharmacyService;

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
               pharmacyStorageRepository.save(p);
                }
            }
        
    }


    // @GetMapping(value="api/get")
    // @Override
    public List<PharmacyStorage> findAllPharmacyStorages()
    {
        List<PharmacyStorage> pharmacyStorageList = pharmacyStorageRepository.findAll();
        return pharmacyStorageList;
    }

    //@GetMapping(value="api/addAlternatives")
    @Override
    public List<String> FindPharmacyMedicine(int pharmacyId) {
        List<Pharmacy> pharmacyList = pharmacyService.findAllPharmacies();  //lista farmacija
        List<PharmacyStorage> pharmacyStorageList = findAllPharmacyStorages(); //lista magacina
        int tempId = pharmacyId;                                                       //pomocna promjenljiva
        List<String> retList = new ArrayList<>();                                   //lista koju vracamo
        PharmacyStorageDTO pharmacyStorageDTO = new PharmacyStorageDTO();
        pharmacyStorageDTO.setPharmacyId(pharmacyId);

        for(PharmacyStorage p : pharmacyStorageList)
        {
            int id = p.getPharmacyId();
            if(id == pharmacyId)
            {
                retList.add(p.getMedicineName());
            }
        }
        return retList;
    }


    @Override
    public void updateAfterCancel(Long medId, Long phId) {
        List<PharmacyStorage> ps=pharmacyStorageRepository.findAll();
        for(PharmacyStorage p:ps){
            if(p.getMedicineId()==medId && p.getPharmacyId()==phId){
               p.setInStock(p.getInStock()+1);
               pharmacyStorageRepository.save(p);
                }
            }
        
    }

    @Override
    public Boolean checkAmount(Long medId, Long phId, int amount) {
        PharmacyStorage ret=new PharmacyStorage();
       List<PharmacyStorage> ps=pharmacyStorageRepository.findAll();
       for(PharmacyStorage p:ps){
           if(p.getMedicineId()==medId && p.getPharmacyId()==phId){
               if(p.getInStock()>=amount){
                   return true;
               }
           }
       }
        return false;
       
    }
    
}
