package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.Users.Pharmacist;

@Entity
@Table(name="Consulting")
public class Consulting {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "Time")
    private LocalTime time;
    @Column(name = "Price")
    private Integer price;
    @Column(name = "Duration")
    private Integer duration;
    @Column(name = "Pharmacist")
    private Pharmacist pharmacist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

}
