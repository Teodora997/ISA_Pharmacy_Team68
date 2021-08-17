package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Medicine;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.MedicineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="api/medicines")
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @Autowired
    MedicineRepository medicineRepository;

    @PostMapping(value = "/addMedicine")
    public ResponseEntity<Medicine> addMedicine(@RequestBody MedicineDTO medicine){
        Medicine m=medicineService.addMedicine(medicine);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @PostMapping(value="/addAlternatives/{id}")
    public ResponseEntity<?> addAlternatives(@RequestBody ArrayList<String> alternativesId, @PathVariable("id") String id){
    
        List<Medicine> alternatives=medicineService.addAlternatives(alternativesId, id);

        return new ResponseEntity<ArrayList<String>>(alternativesId, HttpStatus.CREATED);
    }

     @GetMapping(value = "/getAllMedicines")
    public ResponseEntity<?> getAllMedicines(){
       List<Medicine> medicines=medicineRepository.findAll();
        return new ResponseEntity<>(medicines,HttpStatus.OK);
    }
}
