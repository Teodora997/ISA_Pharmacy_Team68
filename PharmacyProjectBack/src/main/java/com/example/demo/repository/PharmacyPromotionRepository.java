package com.example.demo.repository;

import com.example.demo.model.PharmacyPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyPromotionRepository extends JpaRepository<PharmacyPromotion, Integer> {
}
