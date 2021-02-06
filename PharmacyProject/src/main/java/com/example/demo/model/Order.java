package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;

public class Order {

    @Column(name="Medicines")
    private List<Medicine> medicines;

    @Column(name="Status")
    private String status;

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
