package com.example.demo.dto;
import java.time.LocalDate;

import com.example.demo.model.OrderOfferStatus;

public class OrderMedicinesDTO{
    public Long id;
	public LocalDate timeLimit;
    public String pharmacyName;
	public OrderOfferStatus orderStatus;
    
    public OrderMedicinesDTO() {
    }

    public OrderMedicinesDTO(Long id, LocalDate timeLimit, String pharmacyName, OrderOfferStatus orderStatus) {
        this.id = id;
        this.timeLimit = timeLimit;
        this.pharmacyName = pharmacyName;
        this.orderStatus = orderStatus;
    }

    public Long getId() { 
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public OrderOfferStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderOfferStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    

}