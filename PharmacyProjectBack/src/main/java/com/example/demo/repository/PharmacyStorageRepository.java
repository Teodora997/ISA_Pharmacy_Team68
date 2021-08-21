package com.example.demo.repository;

import com.example.demo.model.PharmacyStorage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyStorageRepository extends JpaRepository<PharmacyStorage,Long> {
    
}
