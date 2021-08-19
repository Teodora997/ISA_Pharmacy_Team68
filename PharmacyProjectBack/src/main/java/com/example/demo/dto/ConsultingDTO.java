package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.ExaminationStatus;

public class ConsultingDTO {
    private Long consultingId;
    private Long pharmacistId;
    private String pharmacistName;
    private double pharmaistRate;
    private Long pharmacyId;
    private String pharmacyName;
    private String pharmacyAddress;
    private Double pharmacyRate;
    private String time;
    private LocalDate date;
    private double price;
    private String patientName;
    private Long patientId;
    private ExaminationStatus examinationStatus;
    boolean rated;
    public ConsultingDTO() {
    }
    
    public ConsultingDTO(Long consultingId, Long pharmacistId, String pharmacistName, double pharmaistRate,
            Long pharmacyId, String pharmacyName, String pharmacyAddress, Double pharmacyRate, String time,
            LocalDate date, double price, String patientName, Long patientId, ExaminationStatus examinationStatus,
            boolean rated) {
        this.consultingId = consultingId;
        this.pharmacistId = pharmacistId;
        this.pharmacistName = pharmacistName;
        this.pharmaistRate = pharmaistRate;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacyRate = pharmacyRate;
        this.time = time;
        this.date = date;
        this.price = price;
        this.patientName = patientName;
        this.patientId = patientId;
        this.examinationStatus = examinationStatus;
        this.rated = rated;
    }

    public ConsultingDTO(Long consultingId, Long pharmacistId, String pharmacistName, double pharmaistRate,
            Long pharmacyId, String pharmacyName, Double pharmacyRate, String time, LocalDate date, double price,
            String patientName, Long patientId, ExaminationStatus examinationStatus, boolean rated) {
        this.consultingId = consultingId;
        this.pharmacistId = pharmacistId;
        this.pharmacistName = pharmacistName;
        this.pharmaistRate = pharmaistRate;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyRate = pharmacyRate;
        this.time = time;
        this.date = date;
        this.price = price;
        this.patientName = patientName;
        this.patientId = patientId;
        this.examinationStatus = examinationStatus;
        this.rated = rated;
    }

    public Long getConsultingId() {
        return consultingId;
    }

    public void setConsultingId(Long consultingId) {
        this.consultingId = consultingId;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public Long getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(Long pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacistName) {
        this.pharmacistName = pharmacistName;
    }

    public double getPharmaistRate() {
        return pharmaistRate;
    }

    public void setPharmaistRate(double pharmaistRate) {
        this.pharmaistRate = pharmaistRate;
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
    public Double getPharmacyRate() {
        return pharmacyRate;
    }
    public void setPharmacyRate(Double pharmacyRate) {
        this.pharmacyRate = pharmacyRate;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public Long getPatientId() {
        return patientId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public ExaminationStatus getExaminationStatus() {
        return examinationStatus;
    }
    public void setExaminationStatus(ExaminationStatus examinationStatus) {
        this.examinationStatus = examinationStatus;
    }
    public boolean isRated() {
        return rated;
    }
    public void setRated(boolean rated) {
        this.rated = rated;
    }

    

    
}
