package com.example.demo.dto;

import javax.persistence.Column;

public class PharmacyPromotionDTO {

    private int id;
    private String medicineName;
    private int pharmacyId;
    private int priceBefore;
    private int priceAfter;
    private String startDate;
    private String endDate;
    private String description;

    public PharmacyPromotionDTO() {}


    public PharmacyPromotionDTO(int id, String medicineName, int pharmacyId, int priceBefore, int priceAfter, String startDate, String endDate, String description) {
        this.id = id;
        this.medicineName = medicineName;
        this.pharmacyId = pharmacyId;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(int priceBefore) {
        this.priceBefore = priceBefore;
    }

    public int getPriceAfter() {
        return priceAfter;
    }

    public void setPriceAfter(int priceAfter) {
        this.priceAfter = priceAfter;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
