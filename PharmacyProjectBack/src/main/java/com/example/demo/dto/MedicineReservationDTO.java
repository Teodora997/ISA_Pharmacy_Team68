package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.MedicineReservationStatus;

public class MedicineReservationDTO {

    private Long id;
    private Long medicineId;
    private String medicineName;
    private Long pharmacyId;
    private String pharmacyName;
    public String pharmacyAddress;
    public Double price;
    public LocalDate date;
    public MedicineReservationStatus status;
    public String code;
    public MedicineReservationDTO() {
    }
    
    public MedicineReservationDTO(Long medicineId, String medicineName, Long pharmacyId, String pharmacyName,
            String pharmacyAddress, Double price, LocalDate date, MedicineReservationStatus status, String code) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.price = price;
        this.date = date;
        this.status = status;
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicineReservationDTO(Long id, Long medicineId, String medicineName, Long pharmacyId, String pharmacyName,
            String pharmacyAddress, Double price, LocalDate date, MedicineReservationStatus status, String code) {
        this.id = id;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.price = price;
        this.date = date;
        this.status = status;
        this.code = code;
    }

    public MedicineReservationDTO(Long medicineId, String medicineName, Long pharmacyId, String pharmacyName,
            String pharmacyAddress, Double price, MedicineReservationStatus status,String code) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.price = price;
        this.status = status;
        this.code=code;
    }

    public MedicineReservationDTO(Long medicineId, String medicineName, Long pharmacyId, String pharmacyName,
            String pharmacyAddress, Double price) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.price = price;
    }

    
    public MedicineReservationStatus getStatus() {
        return status;
    }

    public void setStatus(MedicineReservationStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }
    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
    public Long getPharmacyId() {
        return pharmacyId;
    }
    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
    public String getPharmacyName() {
        return pharmacyName;
    }
    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
    public String getPharmacyAddress() {
        return pharmacyAddress;
    }
    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
}
