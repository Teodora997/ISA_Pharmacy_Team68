package com.example.demo.service.impl;

import com.example.demo.model.Users.PharmacyAdmin;
import com.example.demo.repository.UserRepository.PharmacyAdminRepository;
import com.example.demo.service.PharmacyAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyAdminServiceImpl implements PharmacyAdminService {


    @Autowired
    PharmacyAdminRepository pharmacyAdminRepository;


    @Override
    public List<PharmacyAdmin> getAllAdmins()
    {
        List<PharmacyAdmin> pharmacyAdminList = pharmacyAdminRepository.findAll();
        return pharmacyAdminList;
    }


    @Override
    public int getPharmacyId(int pharmacyAdminId)
    {
        List<PharmacyAdmin> pharmacyAdminList = getAllAdmins();
        int retVal = 0;
        for(PharmacyAdmin p : pharmacyAdminList)
        {
            if(p.getId() == pharmacyAdminId)
            {
                retVal = (p.getPharmacy().getId().intValue());
            }
        }
       // int temp = retVal.intValue();
        return retVal;
    }
}
