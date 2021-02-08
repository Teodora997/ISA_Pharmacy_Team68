package com.example.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name=" medicinePriceList")
public class MedicinePriceList {
    
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = " medicinePriceList")
    //private Set<MedicinePriceListItem>  medicinePriceList;

    @OneToOne(mappedBy = "medicinePriceList")
    private Pharmacy pharmacy;

    @Column(name="FromDate")
    private String fromDate;

    @Column(name="ToDate")
    private String toDate;


    public MedicinePriceList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    
}
