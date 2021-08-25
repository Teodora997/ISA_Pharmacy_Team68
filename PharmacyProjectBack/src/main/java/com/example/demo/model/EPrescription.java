package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.dto.MedFromQRDTO;
import com.example.demo.model.Users.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Eprescription")
public class EPrescription {
    
    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToMany
    @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinTable(name = "eprescription_medicines", joinColumns = @JoinColumn(name = "eprescription_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id", referencedColumnName = "id"))
	private List<MedFromQRDTO> medicines;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false, unique = false)
	public Patient patient;
	
	@Column(name = "pharmacyId")
	private Long pharmacyId;

    @Column(name = "purchased")
    private boolean purchased;

    public EPrescription() {
    }

    public EPrescription(Long id, LocalDate date, List<MedFromQRDTO> medicines, Patient patient, Long pharmacyId,boolean purchased) {
        this.id = id;
        this.date = date;
        this.medicines = medicines;
        this.patient = patient;
        this.pharmacyId = pharmacyId;
        this.purchased=purchased;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MedFromQRDTO> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedFromQRDTO> medicines) {
        this.medicines = medicines;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    

}
