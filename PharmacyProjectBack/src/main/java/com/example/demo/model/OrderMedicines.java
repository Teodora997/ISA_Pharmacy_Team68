package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.model.Users.PharmacyAdmin;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="OrderMedicines")
public class OrderMedicines {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
	private Long id;
	
	@Column(name = "timeLimit")
	private LocalDate timeLimit;
	
	@Column(name = "phAdmin")
	private String phAdmin;

    @JsonIgnore
    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    private Pharmacy pharmacy;

	@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

	@Enumerated(EnumType.ORDINAL)
	private OrderOfferStatus orderStatus;

    public OrderMedicines() {
    }

    public OrderMedicines(Long id, LocalDate timeLimit, String phAdmin, Pharmacy pharmacy,
            List<OrderItem> orderItems, OrderOfferStatus orderStatus) {
        this.id = id;
        this.timeLimit = timeLimit;
        this.phAdmin = phAdmin;
        this.pharmacy = pharmacy;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getPhAdmin() {
        return phAdmin;
    }

    public void setPhAdmin(String phAdmin) {
        this.phAdmin = phAdmin;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderOfferStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderOfferStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

   

}
