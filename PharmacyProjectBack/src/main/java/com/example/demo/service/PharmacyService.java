package com.example.demo.service;

import com.example.demo.repository.ExaminationRepository;
import com.example.demo.repository.PharmacyRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.ExaminationDTO;
import com.example.demo.dto.SearchPharmacyDTO;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService implements IPharmacyService {
    @Autowired
    PharmacyRepository pharmacyRepository;
   
    @Autowired
    ExaminationRepository examinationRepository;

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
    public List<ExaminationDTO> getAvailableExaminations(Long pharmacyId) {
        List<ExaminationDTO> availableExaminations=new ArrayList<>();
        List<Examination> examinations=getExaminationsByPharmacy(pharmacyId);
        for(Examination e:examinations){
            if(e.getStatus()==ExaminationStatus.available|| e.getStatus().equals(ExaminationStatus.canceled)){
                ExaminationDTO ea=new ExaminationDTO();
                ea.setExaminationId(e.getId());
                ea.setDermatologistId(e.getDermatologist().getId());
                ea.setDermatologistName(e.getDermatologist().getFirstName());
                ea.setDermatologistRate(e.getDermatologist().getMark());
                ea.setPrice(e.getPrice());
                ea.setDate(e.getDate());
                ea.setTime(e.getTime());
                availableExaminations.add(ea);

            }
        }
        return availableExaminations;
    }

    public List<Examination> getExaminationsByPharmacy(Long pharmacyId){
        //Pharmacy p=pharmacyRepository.findById(pharmacyId).get();
        List<Examination> ret=new ArrayList<>();
        List<Examination> ex=examinationRepository.findAll();
        for(Examination e:ex){
            if(e.getPharmacy().getId().equals(pharmacyId)){
                ret.add(e);
            }
        }
        return ret;
    }
}
