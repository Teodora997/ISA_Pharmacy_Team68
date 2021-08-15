package com.example.demo.dto;

public class SearchPharmacyDTO {
    private String name;
    private String address;
    private double markTo;
    private double markFrom;
    
    public SearchPharmacyDTO(String name, String address, double markTo, double markFrom) {
        this.name = name;
        this.address = address;
        this.markTo = markTo;
        this.markFrom = markFrom;
    }
    public SearchPharmacyDTO() {
        
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

    public double getMarkTo() {
        return markTo;
    }

    public void setMarkTo(double markTo) {
        this.markTo = markTo;
    }

    public double getMarkFrom() {
        return markFrom;
    }

    public void setMarkFrom(double markFrom) {
        this.markFrom = markFrom;
    }

    
}
