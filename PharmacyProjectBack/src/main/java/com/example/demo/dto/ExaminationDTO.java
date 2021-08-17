package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.ExaminationStatus;

public class ExaminationDTO {
    private Long examinationId;
    private Long dermatologistId;
    private String dermatologistName;
    private double dermatologistRate;
    private Long pharmacyId;
    private String pharmacyName;
    private String time;
    private LocalDate date;
    private double price;
    private String patientName;
    private Long patientId;
    private ExaminationStatus examinationStatus;
    boolean rated;
    public ExaminationDTO() {
    }
    public ExaminationDTO(Long examinationId, Long dermatologistId, String dermatologistName, double dermatologistRate,
            Long pharmacyId, String pharmacyName, String time, LocalDate date, double price, String patientName,
            Long patientId, ExaminationStatus examinationStatus, boolean rated) {
        this.examinationId = examinationId;
        this.dermatologistId = dermatologistId;
        this.dermatologistName = dermatologistName;
        this.dermatologistRate = dermatologistRate;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.time = time;
        this.date = date;
        this.price = price;
        this.patientName = patientName;
        this.patientId = patientId;
        this.examinationStatus = examinationStatus;
        this.rated = rated;
    }
    public Long getExaminationId() {
        return examinationId;
    }
    public void setExaminationId(Long examinationId) {
        this.examinationId = examinationId;
    }
    public Long getDermatologistId() {
        return dermatologistId;
    }
    public void setDermatologistId(Long dermatologistId) {
        this.dermatologistId = dermatologistId;
    }
    public String getDermatologistName() {
        return dermatologistName;
    }
    public void setDermatologistName(String dermatologistName) {
        this.dermatologistName = dermatologistName;
    }
    public double getDermatologistRate() {
        return dermatologistRate;
    }
    public void setDermatologistRate(double dermatologistRate) {
        this.dermatologistRate = dermatologistRate;
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
