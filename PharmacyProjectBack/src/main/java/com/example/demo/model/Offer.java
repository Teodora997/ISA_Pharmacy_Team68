package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.model.Users.Supplier;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Offer")
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderMedicines order;

    @Column(name="totalPrice")
    private Double totalPrice;
    
    @Enumerated(EnumType.ORDINAL)
	private OrderOfferStatus offerStatus;

    @Column(name = "DeliveryDate")
    private LocalDate deliveryDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Supplier supplier;

    public Offer(){

    }

    public Offer(Long id, OrderMedicines order, Double totalPrice, OrderOfferStatus offerStatus, LocalDate deliveryDate,
            Supplier supplier) {
        this.id = id;
        this.order = order;
        this.totalPrice = totalPrice;
        this.offerStatus = offerStatus;
        this.deliveryDate = deliveryDate;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderMedicines getOrder() {
        return order;
    }

    public void setOrder(OrderMedicines order) {
        this.order = order;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderOfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OrderOfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

   
    
   
    
}
