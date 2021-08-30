package com.example.demo.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pharmacyPromotion")
public class PharmacyPromotion {

        @Id
        private int id;

        @Column( name = "medName")
        private String medicineName;

        @Column( name = "pharmacyId")
        private int pharmacyId;

        @Column( name = "priceBefore")
        private int priceBefore;

        @Column( name = "priceAfter")
        private int priceAfter;

        @Column( name = "startDate")
        private String startDate;

        @Column( name = "endDate")
        private String endDate;

        @Column( name = "description")
        private String description;


        public PharmacyPromotion() {

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

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public PharmacyPromotion(int id, String medicineName, int pharmacyId, int priceBefore, int priceAfter,
                             String startDate, String endDate, String description) {
        this.id = id;
        this.medicineName = medicineName;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.pharmacyId = pharmacyId;
    }
}
