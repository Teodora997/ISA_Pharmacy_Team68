package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.PharmacyAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyAdminRepository extends JpaRepository<PharmacyAdmin,Integer>{
    
}
