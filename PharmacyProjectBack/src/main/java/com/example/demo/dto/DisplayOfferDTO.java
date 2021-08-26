package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.OrderOfferStatus;

public class DisplayOfferDTO {
    public Long offerId;
    public Long orderId;
    public String pharmacyName;
    public Long pharmacyId;
    public Double totalPrice;
    public LocalDate deliveryDate;
    public LocalDate timeLimit;
    public OrderOfferStatus offerStatus;
    
    public DisplayOfferDTO() {
    }

    public DisplayOfferDTO(Long offerId, Long orderId, String pharmacyName, Long pharmacyId, Double totalPrice,
            LocalDate deliveryDate, LocalDate timeLimit,OrderOfferStatus offerStatus) {
        this.offerId = offerId;
        this.orderId = orderId;
        this.pharmacyName = pharmacyName;
        this.pharmacyId = pharmacyId;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.timeLimit = timeLimit;
        this.offerStatus=offerStatus;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public OrderOfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OrderOfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
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

    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    
    
}
