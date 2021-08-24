package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.ConsultingDTO;
import com.example.demo.dto.ExaminationDTO;
import com.example.demo.model.Consulting;
import com.example.demo.model.Examination;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;

public interface IPatientService {
    public Set<Medicine> getMyAllergies(String id);
    public Long makeExamination(String patientId,Long examinationId);
    public Integer makeConsulting(String patientId,Long examinationId);
    public List<ConsultingDTO> getPharmaciesForConsulting(LocalDate date,String time);
    public List<ConsultingDTO> getConsultingsByPatient(Long patientId);
    public Consulting cancelConsulting(Long consultingId);
    public List<ExaminationDTO> getExaminationsByPatient(Long patientId);
    public Examination cancelExamination(Long examinationId);
    public Integer makeComplaint(String patientId,Long userId,String text);
    public List<Pharmacy> getPharmaciesForComplaint(Long patientId);
    public Integer makeComplaintPharmacy(String patientId,Long pharmacyId,String text);
    public Double rateUser(Long userId,Double mark);
    public Double rateMedicine(Long medicineId,Double mark);
    public Double ratePharmacy(Long pharmacyId,Double mark);
}
