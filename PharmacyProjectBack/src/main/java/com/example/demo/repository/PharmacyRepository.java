package com.example.demo.repository;

import com.example.demo.model.Pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Long> {
    
}