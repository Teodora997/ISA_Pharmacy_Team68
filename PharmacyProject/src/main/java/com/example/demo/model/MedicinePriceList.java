package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;

public class MedicinePriceList {
    
    @Column(name="Medicine")
    private Medicine medicine;

    @Column(name="Price")
    private Double price;

    @Column(name="FromDate")
    private LocalDate fromDate;

    @Column(name="ToDate")
    private LocalDate toDate;

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
