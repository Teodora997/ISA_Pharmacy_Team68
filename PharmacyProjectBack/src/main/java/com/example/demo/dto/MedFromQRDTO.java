package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medFromQR")
public class MedFromQRDTO {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
   private String name;

   @Column(name = "medicine_id")
   private String medicineId;

   @Column(name = "amount")
   private int amount;
   
public MedFromQRDTO() {
}



public MedFromQRDTO(String name, String medicineId, int amount) {
    this.name = name;
    this.medicineId = medicineId;
    this.amount = amount;
}



public MedFromQRDTO(Long id, String name, String medicineId, int amount) {
    this.id = id;
    this.name = name;
    this.medicineId = medicineId;
    this.amount = amount;
}



public void setId(Long id) {
    this.id = id;
}



public Long getId() {
    return id;
}



public String getMedicineId() {
    return medicineId;
}



public void setMedicineId(String medicineId) {
    this.medicineId = medicineId;
}



public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}



public int getAmount() {
    return amount;
}

public void setAmount(int amount) {
    this.amount = amount;
} 

   
}
