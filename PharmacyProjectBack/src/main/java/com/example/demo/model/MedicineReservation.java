package com.example.demo.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MedicineReservation {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen1",sequenceName = "gen11",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
    private Long id;

    @Column(name = "medicineId")
    private Long medicineId;

    @Column(name = "medicineName")
    private String medicineName;

    @Column(name = "pharmacyId")
    private Long pharmacyId;

    @Column(name = "pharmacyName")
    private String pharmacyName;

    @Column(name = "patientId")
    private Long patientId;

    @Column(name = "patientEmail")
    private String patientEmail;

    @Column(name = "pickUpDate")
    private LocalDate pickUpDate;

    @Column(name = "status")
    private MedicineReservationStatus status;

    @Column(name = "reservationCode")
    private String reservationCode;

    public MedicineReservation(Long medicineId, String medicineName, Long pharmacyId, String pharmacyName, Long patientId,
                               String patientEmail, LocalDate pickUpDate, MedicineReservationStatus status) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.patientId = patientId;
        this.patientEmail = patientEmail;
        this.pickUpDate = pickUpDate;
        this.status = status;
        this.reservationCode  = UUID.randomUUID().toString();
    }

    public MedicineReservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public MedicineReservationStatus getStatus() {
        return status;
    }

    public void setStatus(MedicineReservationStatus status) {
        this.status = status;
    }

   
    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

}
