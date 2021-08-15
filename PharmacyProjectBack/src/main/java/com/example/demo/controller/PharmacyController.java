package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.SearchPharmacyDTO;
import com.example.demo.model.Pharmacy;
import com.example.demo.service.PharmacyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="api/pharmacies")
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;

    @GetMapping(value = "/allPharmacies")
    public ResponseEntity<List<Pharmacy>> getAllPharmacies(){
        List<Pharmacy> pharmacies=pharmacyService.findAllPharmacies();
        return new ResponseEntity<>(pharmacies,HttpStatus.OK);
    }
    @PostMapping(value = "/searchPharmacies")
    public ResponseEntity<List<Pharmacy>> searchPharmacies(@RequestBody SearchPharmacyDTO searchPharmacyDTO){
        List<Pharmacy> pharmacies=pharmacyService.searchPharmacies(searchPharmacyDTO);
        return new ResponseEntity<>(pharmacies,HttpStatus.OK);
    }
}
