package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.Users.Dermatologist;
import com.example.demo.model.Users.Pharmacist;

@Entity
@Table(name = "Pharmacies")
public class Pharmacy {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name")
    private LocalDate name;

    @Column(name = "Address")
    private LocalTime adress;

    @Column(name = "Dermatologist")
    private List<Dermatologist> dermatologist;

    @Column(name = "Pharmacist")
    private List<Pharmacist> pharmacist;

    @Column(name = "Medicines")
    private List<Medicine> medicines;
    
    @Column(name = "Examinations")
    private List<Examination> examinations;
    
    @Column(name="Mark")
    private Integer mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getName() {
        return name;
    }

    public void setName(LocalDate name) {
        this.name = name;
    }

    public LocalTime getAdress() {
        return adress;
    }

    public void setAdress(LocalTime adress) {
        this.adress = adress;
    }


    public List<Dermatologist> getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(List<Dermatologist> dermatologist) {
        this.dermatologist = dermatologist;
    }

    public List<Pharmacist> getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(List<Pharmacist> pharmacist) {
        this.pharmacist = pharmacist;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
