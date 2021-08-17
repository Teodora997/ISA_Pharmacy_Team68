package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.SearchPharmacyDTO;
import com.example.demo.model.Pharmacy;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.service.PharmacyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="api/pharmacies")
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;
    @Autowired
    PharmacyRepository pharmacyRepository;

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
    @GetMapping(value = "/getPharmacy/{id}")
    public ResponseEntity<Pharmacy> getPharmacy(@PathVariable Long id){
        System.out.println("TRAZI APOTEKU SA ID "+ id);
        Pharmacy pharmacy=pharmacyRepository.findById(id).get();
        System.out.println("Nasao apoteku "+ pharmacy.getName());
        return new ResponseEntity<>(pharmacy,HttpStatus.OK);
    }
    @PostMapping(value = "/addPharmacy")
    public ResponseEntity<Pharmacy> addPharmacy(@RequestBody Pharmacy pharmacy){
        Pharmacy p=pharmacyService.addPharmacy(pharmacy);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}
