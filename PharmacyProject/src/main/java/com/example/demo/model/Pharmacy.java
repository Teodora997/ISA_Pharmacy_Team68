package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
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

    @OneToOne(fetch =FetchType.LAZY )
    @JoinColumn(name="IdMedPriceList",referencedColumnName ="id" )
    private MedicinePriceList medicinePriceList;

    @OneToOne(fetch =FetchType.LAZY )
    @JoinColumn(name="IdExPriceList",referencedColumnName ="id" )
    private MedicinePriceList ExaminationPriceList;



    public Pharmacy() {
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
