package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderItem")
public class OrderItem {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
	private Long id;
	
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medicine_id", referencedColumnName = "id", nullable = false)
	private Medicine medicine;

	@Column(name = "amount")
	private Integer amount;

    public OrderItem() {
    }

    public OrderItem(Long id, Medicine medicine, Integer amount) {
        this.id = id;
        this.medicine = medicine;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    
}
