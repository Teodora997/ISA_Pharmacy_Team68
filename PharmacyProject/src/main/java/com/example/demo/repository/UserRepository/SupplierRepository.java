package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    
}
