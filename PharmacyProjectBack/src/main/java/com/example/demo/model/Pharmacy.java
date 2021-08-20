package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "Pharmacies")
public class Pharmacy {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;
    
    @Column(name="Mark")
    private Double mark;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="IdMedPriceList",referencedColumnName ="id" )
    private MedicinePriceList medicinePriceList;

    @OneToOne(fetch =FetchType.EAGER )
    @JoinColumn(name="IdExPriceList",referencedColumnName ="id" )
    private MedicinePriceList ExaminationPriceList;



    public Pharmacy() {
    }
    
    
    public void setAddress(String address) {
        this.address = address;
    }


    public MedicinePriceList getMedicinePriceList() {
        return medicinePriceList;
    }


    public void setMedicinePriceList(MedicinePriceList medicinePriceList) {
        this.medicinePriceList = medicinePriceList;
    }


    public MedicinePriceList getExaminationPriceList() {
        return ExaminationPriceList;
    }


    public void setExaminationPriceList(MedicinePriceList examinationPriceList) {
        ExaminationPriceList = examinationPriceList;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    
}
