package com.example.demo.repository;

import com.example.demo.dto.MedFromQRDTO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedFromQRRepository extends JpaRepository<MedFromQRDTO,Long>{
    
}
