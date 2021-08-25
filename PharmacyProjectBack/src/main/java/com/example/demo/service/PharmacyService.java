package com.example.demo.service;

import com.example.demo.repository.ExaminationRepository;
import com.example.demo.repository.MedicinePLItemRepository;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.UserRepository.PharmacyAdminRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.ExaminationDTO;
import com.example.demo.dto.PhPriceForMedicineDTO;
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

   @Autowired
   MedicinePLItemRepository medicinePLItemRepository;

   
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
    @Override
    public List<ExaminationDTO> getAvailableExaminations(Long pharmacyId) {
        List<ExaminationDTO> availableExaminations=new ArrayList<>();
        List<Examination> examinations=getExaminationsByPharmacy(pharmacyId);
        for(Examination e:examinations){
            if(e.getDate().isAfter(LocalDate.now())){
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

    @Override
    public List<PhPriceForMedicineDTO> getPharmaciesForMedicine(String medicineId) {
        System.out.println("U PHARMACY SERVISU SAM,TRAZIM APOTEKE ZA LIJEK SA ID: "+medicineId);
        Long mId=Long.parseLong(medicineId);
       List<MedicinePriceListItem> items=medicinePLItemRepository.findAll();
       List<MedicinePriceListItem> items1=new ArrayList<MedicinePriceListItem>();
       
       List<PhPriceForMedicineDTO> ret=new ArrayList<PhPriceForMedicineDTO>();

       for(MedicinePriceListItem i:items){
           if(i.getMedicine().getId()==mId){
                items1.add(i);
           }
       }
       System.out.println("POKUPILO ITEME SA OVIM MEDICINE ID");

    //   List<Long> priceListIds=new ArrayList<Long>();
    //   for(MedicinePriceListItem p:items1){
    //     priceListIds.add(p.getMedicinePriceList().getId());
    //     System.out.println("u foru: "+p.getMedicine().getName());
    //   }

      System.out.println("POKUPILO ID CJENOVNIKA GDJE IMA LIJEK");

        List<Pharmacy> pharmacies=pharmacyRepository.findAll();


        for(MedicinePriceListItem i:items1){
        for(Pharmacy p:pharmacies){
            if(p.getMedicinePriceList().getId()==i.getMedicinePriceList().getId()){
    
                System.out.println("u foru 2: "+p.getName());
                PhPriceForMedicineDTO php=new PhPriceForMedicineDTO();
                php.setName(p.getName());
                php.setAddress(p.getAddress());
                php.setPrice(i.getPrice());
                php.setId(p.getId());
                ret.add(php);
                
            }
        }
    }
    System.out.println("NASLO APOTEKE GDJE IMA LIJEK");
        return ret;
    }
   
   
}
