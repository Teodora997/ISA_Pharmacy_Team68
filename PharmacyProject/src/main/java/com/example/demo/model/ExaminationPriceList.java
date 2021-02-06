package com.example.demo.model;

import javax.persistence.Column;

public class ExaminationPriceList {

    @Column(name="Examinations")
    private String examintaion;

    @Column(name="Price")
    private Double price;

    public String getExamintaion() {
        return examintaion;
    }

    public void setExamintaion(String examintaion) {
        this.examintaion = examintaion;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
