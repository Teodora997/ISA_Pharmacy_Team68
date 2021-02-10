package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.model.Users.Supplier;

@Entity
@Table(name="Offer")
public class Offer {
    
    @Id
    @Column(name="Id")
    private Long id;

    @Column(name="idOrder")
    private Integer idOrder;

    @Column(name="Price")
    private Double price;
    
    @Column(name="Status")
    private String status;

    @Column(name = "DeliveryDate")
    private String deliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

    public Offer(){

    }
    
    public Long getId() {
        return id;
    }
    public Offer(Long id, Integer idOrder, Double price, String status, String deliveryDate, Supplier supplier) {
        this.id = id;
        this.idOrder = idOrder;
        this.price = price;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.supplier = supplier;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    
}
