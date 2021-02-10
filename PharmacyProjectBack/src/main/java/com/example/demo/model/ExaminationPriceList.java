package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ExaminationPriceList")
public class ExaminationPriceList {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Examinations")
    private String examination;

    @Column(name="Price")
    private Double price;

    @OneToOne(mappedBy = "ExaminationPriceList")
    private Pharmacy pharmacy;
    
    public ExaminationPriceList(){

    }

    public ExaminationPriceList(Long id, String examination, Double price,Pharmacy pharmacy) {
        this.id = id;
        this.examination = examination;
        this.price = price;
        this.pharmacy=pharmacy;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }
    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    
}
