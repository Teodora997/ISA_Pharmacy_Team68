package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DisplayOfferDTO;
import com.example.demo.dto.OfferDTO;

public interface OfferService {
    void sendOffer(Long userId,Long orderId,OfferDTO offer);
    List<DisplayOfferDTO> getOffers(Long userId);
}
