package com.example.demo.service;

import com.example.demo.repository.PharmacyRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.SearchPharmacyDTO;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService implements IPharmacyService {
    @Autowired
    PharmacyRepository pharmacyRepository;
   
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


}
