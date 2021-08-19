package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.ConsultingDTO;
import com.example.demo.model.Consulting;
import com.example.demo.model.Examination;
import com.example.demo.model.ExaminationStatus;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Users.Patient;
import com.example.demo.model.Users.Pharmacist;
import com.example.demo.repository.ConsultingRepository;
import com.example.demo.repository.ExaminationRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.repository.UserRepository.PharmacistRepository;
import com.example.demo.service.IPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private ConsultingRepository consultingRepository;
    @Autowired
    private PharmacistRepository pharmacistRepository;

    
    public PatientService(PatientRepository patientRepository, ExaminationRepository examinationRepository,
            ConsultingRepository consultingRepository, PharmacistRepository pharmacistRepository) {
        this.patientRepository = patientRepository;
        this.examinationRepository = examinationRepository;
        this.consultingRepository = consultingRepository;
        this.pharmacistRepository = pharmacistRepository;
    }

    @Override
    public Set<Medicine> getMyAllergies(String id) {
        Patient p=patientRepository.findById(Long.parseLong(id)).get();

        return p.getAllergies();
    }

    @Override
    public Long makeExamination(String patientId, Long examinationId) {
        Examination examination=examinationRepository.findById(examinationId).get();
        examination.setStatus(ExaminationStatus.scheduled);
        Patient patient=patientRepository.findById(Long.parseLong(patientId)).get();
        examination.setPatient(patient);
        examinationRepository.save(examination);
        return examinationId;
    }

    @Override
    public List<ConsultingDTO> getPharmaciesForConsulting(LocalDate date, String time) {
        List<Consulting> allConsultings=new ArrayList<>();
        allConsultings=consultingRepository.findAll();
        System.out.println("svi pregledi "+allConsultings+date);
        List<ConsultingDTO> ret=new ArrayList<>();
        for(Consulting c:allConsultings){
            System.out.println("u for "+c.getDate());
            if(c.getDate().compareTo(date)==0 && c.getTime().equals(time)){
                System.out.println("u ifuuu");
                if(c.getStatus().equals(ExaminationStatus.available) || c.getStatus().equals(ExaminationStatus.canceled)){
                System.out.println("USAO U IF"+c.getPharmacist().getFirstName());
                    ConsultingDTO cd=new ConsultingDTO();
                cd.setConsultingId(c.getId());
                cd.setDate(date);
                Pharmacy ph=pharmacistRepository.findById(c.getPharmacist().getId()).get().getPharmacy();
                cd.setPharmacyId(ph.getId());
                cd.setPharmacyName(ph.getName());
                cd.setPharmacyAddress(ph.getAddress());
                cd.setPharmacyRate(ph.getMark());
                cd.setPrice(c.getPrice());
                cd.setPharmacistId(c.getPharmacist().getId());
                cd.setPharmacistName(c.getPharmacist().getFirstName().concat(c.getPharmacist().getLastName()));
                cd.setPharmaistRate(c.getPharmacist().getMark());
                ret.add(cd);
            }
        }
    }
         System.out.println("Pronasao "+ret);
        return ret;
    }

    @Override
    public Long makeConsulting(String patientId, Long consultingId) {
        System.out.println("rezervacija pregleda servis ");
        Consulting consulting=consultingRepository.findById(consultingId).get();
        consulting.setStatus(ExaminationStatus.scheduled);
        Patient patient=patientRepository.findById(Long.parseLong(patientId)).get();
        consulting.setPatient(patient);
        consultingRepository.save(consulting);
        return consultingId;
    }

    @Override
    public List<ConsultingDTO> getConsultingsByPatient(Long patientId) {
        List<Consulting> cons=new ArrayList<>();
        cons=consultingRepository.findAll();
        System.out.println("svi pregledi"+ cons);
        List<ConsultingDTO> ret=new ArrayList<>();
        for(Consulting c:cons){
            if(c.getPatient()!=null ){
                System.out.println("u ifu 1"+c.getPatient().getId()+" "+patientId);
                if(c.getPatient().getId().equals(patientId)){
                    System.out.println("u ifu 2");
               ConsultingDTO cd=new ConsultingDTO();
                cd.setConsultingId(c.getId());
                cd.setDate(c.getDate());
                cd.setTime(c.getTime());
                Pharmacy ph=pharmacistRepository.findById(c.getPharmacist().getId()).get().getPharmacy();
                cd.setPharmacyId(ph.getId());
                cd.setPharmacyName(ph.getName());
                cd.setPharmacyAddress(ph.getAddress());
                cd.setPharmacyRate(ph.getMark());
                cd.setPrice(c.getPrice());
                cd.setPharmacistId(c.getPharmacist().getId());
                cd.setPharmacistName(c.getPharmacist().getFirstName().concat(c.getPharmacist().getLastName()));
                cd.setPharmaistRate(c.getPharmacist().getMark()); 
                cd.setPatientId(patientId);
                ret.add(cd);
                
            }
        }
    }
    System.out.println("pregledii "+ret);
        return ret;
    }
}
