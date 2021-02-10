package com.example.demo.repository;

import com.example.demo.model.OrderMedicine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMedicineRepository extends JpaRepository<OrderMedicine,Long> {
    
}