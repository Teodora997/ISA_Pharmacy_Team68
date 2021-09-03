package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.example.demo.model.Users.Patient;
import com.example.demo.model.Users.Pharmacist;

@Entity
@Table(name="Consulting")
public class Consulting {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "Time")
    private String time;
    @Column(name = "Price")
    private Double price;
    @Column(name = "Duration")
    private Integer duration;
   
    @ManyToOne(fetch = FetchType.LAZY)
    private Pharmacist pharmacist;

    @ManyToOne(fetch =FetchType.LAZY)
    private Patient patient;

    @Enumerated(EnumType.ORDINAL)
    private ExaminationStatus status;


    public Consulting(){
        
    }
    

    public Consulting(Long id, LocalDate date, String time, Double price, Integer duration, Pharmacist pharmacist,
            Patient patient, ExaminationStatus status) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.duration = duration;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.status = status;
    }

    public Consulting(Long id, LocalDate date, String time, Double price, Integer duration, Pharmacist pharmacist,
            Patient patient) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.duration = duration;
        this.pharmacist = pharmacist;
        this.patient = patient;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ExaminationStatus getStatus() {
        return status;
    }

    public void setStatus(ExaminationStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    



}
