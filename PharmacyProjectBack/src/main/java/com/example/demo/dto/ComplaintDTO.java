package com.example.demo.dto;

import java.time.LocalDate;

public class ComplaintDTO {
    private Long id;
    private String text;
    private String name;
    private Long patientId;
    private String email;
    private LocalDate date;
    
    public ComplaintDTO() {
    }

    public ComplaintDTO(Long id, String text, String name, Long patientId, String email, LocalDate date) {
        this.id = id;
        this.text = text;
        this.name = name;
        this.patientId = patientId;
        this.email = email;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    
    
}
