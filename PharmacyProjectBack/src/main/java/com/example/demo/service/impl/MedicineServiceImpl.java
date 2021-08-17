package com.example.demo.service.impl;

import java.util.List;

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
        System.out.println(m.getId());
        Medicine m1=medicineRepository.findById(Long.parseLong(m.getId())).get();
        if(m1==null){
            
            medicine.setId(Long.parseLong(m.getId()));
            medicine.setName(m.getName());
            medicine.setType(m.getType());
            medicine.setForm(m.getForm());
            medicine.setIngredients(m.getIngredients());
            medicine.setRegime(m.getRegime());
            medicine.setProducer(m.getProducer());
            medicine.setAdditional(m.getAdditional());
            medicine.setAlternative(Integer.parseInt(m.getAlternative()));

            medicineRepository.save(medicine);
            return medicine;
        }else{
            return null;
        }
    }

    
    
}
