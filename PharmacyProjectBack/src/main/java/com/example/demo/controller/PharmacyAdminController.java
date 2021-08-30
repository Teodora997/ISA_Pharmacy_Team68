package com.example.demo.controller;


import com.example.demo.service.impl.PharmacyAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/phadmin")
public class PharmacyAdminController {

    @Autowired
    PharmacyAdminServiceImpl pharmacyAdminService;

    @GetMapping(value = "/getPharmacyId/{id}")
    public ResponseEntity<?> getPharmacyId(@PathVariable(name="id") String id)
    {
        int temp= Integer.valueOf(id, 10);
        int pharmacyId = pharmacyAdminService.getPharmacyId(temp);

        return new ResponseEntity<>(pharmacyId, HttpStatus.OK);

    }
}
