package com.example.demo.service;

import com.example.demo.model.PharmacyPromotion;

import java.util.List;

public interface IPharmacyPromotionService {
    public boolean isFirst();
    public List<PharmacyPromotion> getAllPromotions();
    public Integer returnLastIndex();
    public void savePromotion(PharmacyPromotion p);
}
