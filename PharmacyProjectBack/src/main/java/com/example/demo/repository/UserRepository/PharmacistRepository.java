package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.Pharmacist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    
}
