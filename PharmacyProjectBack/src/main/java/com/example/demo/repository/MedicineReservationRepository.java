package com.example.demo.repository;

import com.example.demo.model.MedicineReservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineReservationRepository extends JpaRepository<MedicineReservation,Long> {
    
}
