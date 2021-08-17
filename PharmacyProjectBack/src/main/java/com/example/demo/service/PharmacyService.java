package com.example.demo.service;

import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.UserRepository.PharmacyAdminRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.SearchPharmacyDTO;
import com.example.demo.model.*;
import com.example.demo.model.Users.PharmacyAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService implements IPharmacyService {
    @Autowired
    PharmacyRepository pharmacyRepository;
   @Autowired
   PharmacyAdminRepository pharmacyAdminRepository;

   
    @Override
    public List<Pharmacy> findAllPharmacies(){
        return pharmacyRepository.findAll();
    }

    @Override
    public List<Pharmacy> searchPharmacies(SearchPharmacyDTO searchPharmacyDTO) {
        List<Pharmacy> pharmacies=new ArrayList<>();
        pharmacies=findAllPharmacies();
        List<Pharmacy> ret=new ArrayList<>();
        for(Pharmacy p1:pharmacies){
            ret.add(p1);
        }
        System.out.println("PRETRAGA ->NAZIV"+searchPharmacyDTO.getName());
        for(Pharmacy p:pharmacies){
            if (!searchPharmacyDTO.getName().equals("all")) {
                if (!p.getName().toLowerCase().equals(searchPharmacyDTO.getName().toLowerCase())) {
                    // and it is in the ret list
                    if (ret.contains(p)) {
                        // remove it from the ret list
                        ret.remove(p);
                    }
                }
            }
            if (!searchPharmacyDTO.getAddress().equals("all")) {
                if (!p.getAddress().toLowerCase().equals(searchPharmacyDTO.getAddress().toLowerCase())) {
                    // and it is in the ret list
                    if (ret.contains(p)) {
                        // remove it from the ret list
                        ret.remove(p);
                    }
                }
            }
        }

System.out.println("REZULTAT"+ret);
        return ret;
    }

    @Override
    public Pharmacy addPharmacy(Pharmacy pharmacy) {
       pharmacyRepository.save(pharmacy);
       return pharmacy;
    }

    @Override
    public List<Pharmacy> getAvailablePharmacies() {
        
        List<PharmacyAdmin> admins=pharmacyAdminRepository.findAll();
        List<Pharmacy> pharmacies=pharmacyRepository.findAll();
        Boolean available=true;

        List<Pharmacy> availablePh=new ArrayList<Pharmacy>();

        List<Long> ids= new ArrayList<Long>();


        for(PharmacyAdmin a:admins){
            ids.add(a.getPharmacy().getId());
        }

        for(Pharmacy p:pharmacies){
            if(!ids.contains(p.getId())){
    
                availablePh.add(p);
                System.out.println("APOTEKA SA ID: "+p.getId()+"JE SLOBODNA");
            }
        }
        // for(Pharmacy ph:pharmacies){
        //    for(PharmacyAdmin a:admins){
        //        if(a.getPharmacy().getId()!=ph.getId()){
        //             available=true;
        //        }else{
        //            available=false;

        //        }
        //    }
        //    if(available){
        //        availablePh.add(ph);
        //    }
        // }
        

        return availablePh;
    }


}
