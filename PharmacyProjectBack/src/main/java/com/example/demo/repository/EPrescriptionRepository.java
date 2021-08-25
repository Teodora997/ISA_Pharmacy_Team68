package com.example.demo.repository;

import com.example.demo.model.EPrescription;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EPrescriptionRepository extends JpaRepository<EPrescription,Long> {
    
}
