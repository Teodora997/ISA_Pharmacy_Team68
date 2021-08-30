package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PharmacyStorage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pharmacyId", nullable = false)
    private int pharmacyId;

    @Column(name = "medicineId", nullable = false)
    private int medicineId;

    @Column(name = "medicineName", nullable = false)
    private String medicineName;

    @Column(name = "inStock", nullable = false)
    private int inStock;

    @Column(name = "reserved", nullable = false)
    private int reserved;

    public PharmacyStorage() {
    }

    public PharmacyStorage(int pharmacyId, int medicineId, int inStock, int reserved, String medicineName) {
        this.pharmacyId = pharmacyId;
        this.medicineId = medicineId;
        this.inStock = inStock;
        this.reserved = reserved;
        this.medicineName = medicineName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
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
