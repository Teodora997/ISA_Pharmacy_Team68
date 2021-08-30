package com.example.demo.service;

import com.example.demo.model.Users.PharmacyAdmin;

import java.util.List;

public interface PharmacyAdminService {


    public List<PharmacyAdmin> getAllAdmins();
    public int getPharmacyId(int pharmacyAdminId);

    
}
