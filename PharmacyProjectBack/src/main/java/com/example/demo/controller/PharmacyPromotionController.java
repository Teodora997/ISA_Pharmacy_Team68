package com.example.demo.controller;


import com.example.demo.model.MedicinePriceListItem;
import com.example.demo.model.PharmacyPromotion;
import com.example.demo.repository.MedicinePLItemRepository;
import com.example.demo.repository.PharmacyPromotionRepository;
import com.example.demo.service.PharmacyAdminService;
import com.example.demo.service.PharmacyPromotionService;
import com.example.demo.service.impl.PharmacyAdminServiceImpl;
import com.example.demo.service.impl.PharmacyStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/promotion")
public class PharmacyPromotionController {

    @Autowired
    PharmacyPromotionRepository pharmacyPromotionRepository;

    @Autowired
    PharmacyPromotionService pharmacyPromotionService;

    @Autowired
    PharmacyAdminServiceImpl pharmacyAdminService;

    @Autowired
    PharmacyStorageService pharmacyStorageService;

    @Autowired
    MedicinePLItemRepository medicinePLItemRepository;


    @GetMapping(value = "/allPromotions")
    public ResponseEntity<List<PharmacyPromotion>> getAllPharmacyPromotions()
    {
        List<PharmacyPromotion> promotionList = pharmacyPromotionService.getAllPromotions();
            return new ResponseEntity<>(promotionList, HttpStatus.OK);
    }

    @PostMapping(value = "/addPromotion")
    public ResponseEntity<PharmacyPromotion> addPromotion(@RequestBody PharmacyPromotion p)
    {
        int temp;
        int index = pharmacyPromotionService.returnLastIndex();
        if(index == 0)
        {
            temp = 1;
        }
        else temp = ++index;
        p.setId(temp);
        pharmacyPromotionService.savePromotion(p);
            return new ResponseEntity<>(p, HttpStatus.OK);

    }

    @GetMapping(value = "/getMedicinesForPromotion/{adminId}")
    public ResponseEntity<List<String>> getMedicinesForPromotion(@PathVariable("adminId") String adminId)
    {
        int temp = Integer.valueOf(adminId, 10);
        int pharmacyId = pharmacyAdminService.getPharmacyId(temp);


        List<String> medList = pharmacyStorageService.FindPharmacyMedicine(pharmacyId);

        return new ResponseEntity<>(medList, HttpStatus.OK);
    }

    @GetMapping(value = "/getPrices")
    public List<MedicinePriceListItem> getPrices()
    {
        List<MedicinePriceListItem> list = medicinePLItemRepository.findAll();
        return list;
    }

    @GetMapping(value = "/getMedicinePrice/{medName}")
    public ResponseEntity<String> getMedicinePrice(@PathVariable("medName") String medName)
    {
        List<MedicinePriceListItem> lista = getPrices();
        double temp = 0;
        String retVal;
        for(MedicinePriceListItem m : lista)
        {
            if(m.getName().equals(medName))
            {
                temp = m.getPrice();
            }
        }
            retVal = String.valueOf(temp);
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
}
