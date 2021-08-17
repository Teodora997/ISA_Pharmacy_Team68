package com.example.demo.controller;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Medicine;
import com.example.demo.service.MedicineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/medicines")
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @PostMapping(value = "/addMedicine")
    public ResponseEntity<Medicine> addMedicine(@RequestBody MedicineDTO medicine){
        Medicine m=medicineService.addMedicine(medicine);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
}
