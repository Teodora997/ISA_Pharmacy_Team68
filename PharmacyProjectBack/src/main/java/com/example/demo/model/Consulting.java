package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private String date;
    @Column(name = "Time")
    private String time;
    @Column(name = "Price")
    private Integer price;
    @Column(name = "Duration")
    private Integer duration;
   
    @ManyToOne(fetch = FetchType.LAZY)
    private Pharmacist pharmacist;

    @ManyToOne(fetch =FetchType.LAZY)
    private Patient patient;

    public Consulting(){
        
    }

    public Consulting(Long id, String date, String time, Integer price, Integer duration, Pharmacist pharmacist,
            Patient patient) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.duration = duration;
        this.pharmacist = pharmacist;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    



}
