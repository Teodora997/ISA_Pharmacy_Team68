package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Medicine;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.MedicineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public List<Medicine> findAllMedicines() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Medicine addMedicine(MedicineDTO m) {
        Medicine medicine=new Medicine();
        System.out.println("ID LIJEKA: "+m.getId());
        Long id=Long.parseLong(m.getId());
        System.out.println("LONG ID LIJEKA: "+id);
        
        Medicine m1=findById(id);
        if(m1==null){
            
            medicine.setId(Long.parseLong(m.getId()));
            medicine.setName(m.getName());
            medicine.setType(m.getType());
            medicine.setForm(m.getForm());
            medicine.setIngredients(m.getIngredients());
            medicine.setRegime(m.getRegime());
            medicine.setProducer(m.getProducer());
            medicine.setAdditional(m.getAdditional());
           

            medicineRepository.save(medicine);
            return medicine;
        }else{
            return null;
        }
    }

    @Override
    public Medicine findById(Long id) {
        try {
            Medicine medicine=medicineRepository.findById(id).get();
            return medicine;
        } catch (NoSuchElementException e) {
           return null;
        }
    }

    @Override
    public List<Medicine> addAlternatives(ArrayList<String> alternativesId, String id) {
        List<Medicine> alternatives = new ArrayList<Medicine>();
        Long mId=Long.parseLong(id);
       Medicine medicine =findById(mId);
       if(medicine!=null){
           for(String altId : alternativesId){
               Long aId=Long.parseLong(altId);
               Medicine alt = findById(aId);
               if(alt!=null){
                    medicine.getAlternative().add(alt);
                    alternatives.add(alt);
               }

           }
           medicineRepository.save(medicine);
           return alternatives;
       }



        return null;
    }

    
    
}
