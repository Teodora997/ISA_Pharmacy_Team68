package com.example.demo.dto;

public class PharmaciesEPrescriptionDTO {
    public Long  id;
    public String name;
    public String address;
    public Double totalPrice;

    
    public PharmaciesEPrescriptionDTO() {
    }


    public PharmaciesEPrescriptionDTO(Long id, String name, String address, Double totalPrice) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.totalPrice = totalPrice;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }


    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
}
