package com.example.demo.dto;

import com.example.demo.model.PharmacyStorage;

public class PharmacyStorageDTO {
        private Long id;
        private int pharmacyId;
        private int medicineId;
        private String medicineName;
        private int inStock;
        private int reserved;

        public PharmacyStorageDTO() {

        }


    public PharmacyStorageDTO(Long id, int pharmacyId, int medicineId, String medicineName, int inStock, int reserved) {
        this.id = id;
        this.pharmacyId = pharmacyId;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.inStock = inStock;
        this.reserved = reserved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }
}
