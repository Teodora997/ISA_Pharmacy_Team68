package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.model.Users.Dermatologist;
import com.example.demo.model.Users.Patient;


@Entity
@Table(name = "Examinations")
public class Examination {
    
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Date")
    private String date;
    @Column(name = "Time")
    private String time;
    @Column(name = "Price")
    private Integer price;
    @Column(name = "Duration")
    private Integer duration;
   
    @ManyToOne(fetch = FetchType.LAZY)
    private Dermatologist dermatologist;

    @ManyToOne(fetch =FetchType.LAZY)
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

    @Enumerated(EnumType.ORDINAL)
    private ExaminationStatus status;

    public Examination(){
        
    }

    public Examination(Long id, String date, String time, Integer price, Integer duration, Dermatologist dermatologist,
            Patient patient, Pharmacy pharmacy, ExaminationStatus status) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.duration = duration;
        this.dermatologist = dermatologist;
        this.patient = patient;
        this.pharmacy = pharmacy;
        this.status = status;
    }

    public ExaminationStatus getStatus() {
        return status;
    }

    public void setStatus(ExaminationStatus status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
    


}
