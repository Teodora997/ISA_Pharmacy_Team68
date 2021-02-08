package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MedPriceListItems")
public class MedicinePriceListItem {
    
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private Double price;

    @ManyToOne(fetch=FetchType.LAZY)
    private MedicinePriceList medicinePriceList;

    @ManyToOne(fetch =FetchType.LAZY )
    private Medicine medicine;

    public MedicinePriceListItem(){

    }

    public MedicinePriceListItem(String name, Double price) {
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MedicinePriceList getMedicinePriceList() {
        return medicinePriceList;
    }

    public void setMedicinePriceList(MedicinePriceList medicinePriceList) {
        this.medicinePriceList = medicinePriceList;
    }

    

}
