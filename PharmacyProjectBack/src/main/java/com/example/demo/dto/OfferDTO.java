package com.example.demo.dto;

import java.time.LocalDate;

public class OfferDTO {
    public Double totalPrice;
    public LocalDate deliveryDate;

    
    public OfferDTO() {
    }
    public OfferDTO(Double totalPrice, LocalDate deliveryDate) {
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    
}
