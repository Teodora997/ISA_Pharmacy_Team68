package com.example.demo.dto;

public class PhPriceForMedicineDTO {
    public String name;
    public String address;
    public Double price;
    public Long id;

    public PhPriceForMedicineDTO() {
    
    }

    public PhPriceForMedicineDTO(String name, String address, Double price, long id) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhPriceForMedicineDTO(String name, String address, Double price) {
        this.name = name;
        this.address = address;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    
}
