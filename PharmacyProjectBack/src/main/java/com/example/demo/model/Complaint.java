package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.example.demo.model.Users.Patient;

@Entity
@Table(name="Complaints")
public class Complaint {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Text")
    private String text;

    @ManyToOne(fetch =FetchType.LAZY)
    private Patient patient; 

    @Column(name = "isAnswered")
    private Boolean isAnswered;

    @Column(name = "ComplaintFor")
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @Version
    @Column(name = "version", nullable = true)
    private Long version;

    public Complaint() {
    }

    public Complaint(Long id, String text, Boolean isAnswered, LocalDate date,Patient patient) {
        this.id = id;
        this.text = text;
        this.isAnswered = isAnswered;
        this.date = date;
        this.patient=patient;
    }

    public Complaint(Long id, String text, Patient patient, Boolean isAnswered, String name, LocalDate date) {
        this.id = id;
        this.text = text;
        this.patient = patient;
        this.isAnswered = isAnswered;
        this.name = name;
        this.date = date;
    }

    

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    
    
}
