package com.example.demo.repository;

import com.example.demo.model.RequestForReg;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestForRegRepository extends JpaRepository<RequestForReg,Long> {
    
}
