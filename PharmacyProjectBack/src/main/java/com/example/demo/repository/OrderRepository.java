package com.example.demo.repository;

import com.example.demo.model.OrderMedicines;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderMedicines,Long>{
    
}
