package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.Users.Dermatologist;


@Entity
@Table(name = "Examinations")
public class Examination {
    
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
    @Column(name = "Dermatologist")
    private Dermatologist dermatologist;

    @Column()

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

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    








}
