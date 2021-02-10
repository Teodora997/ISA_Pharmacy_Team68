package com.example.demo.repository;

import com.example.demo.model.MedicinePriceListItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinePLItemRepository extends JpaRepository<MedicinePriceListItem,Long> {
    
}