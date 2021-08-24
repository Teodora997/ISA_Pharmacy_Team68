package com.example.demo.dto;

import java.util.List;


public class AvailabiltyInPhEPrescriptionDTO {
    private Long prescriptionId;
    private List<MedFromQRDTO> medicines;
    private List<PharmaciesEPrescriptionDTO> pharmacies;

    public AvailabiltyInPhEPrescriptionDTO() {
    }

    public AvailabiltyInPhEPrescriptionDTO(Long id,List<MedFromQRDTO> medicines, List<PharmaciesEPrescriptionDTO> pharmacies) {
        this.prescriptionId=id;
        this.medicines = medicines;
        this.pharmacies = pharmacies;
    }

    
    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public List<MedFromQRDTO> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedFromQRDTO> medicines) {
        this.medicines = medicines;
    }

    public List<PharmaciesEPrescriptionDTO> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<PharmaciesEPrescriptionDTO> pharmacies) {
        this.pharmacies = pharmacies;
    }

    
    
    
}
