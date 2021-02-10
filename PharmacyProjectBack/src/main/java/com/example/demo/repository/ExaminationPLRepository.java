package com.example.demo.repository;

import com.example.demo.model.ExaminationPriceList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationPLRepository extends JpaRepository<ExaminationPriceList,Long> {
    
}