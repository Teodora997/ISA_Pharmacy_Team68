package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.ConsultingDTO;
import com.example.demo.dto.ExaminationDTO;
import com.example.demo.model.Consulting;
import com.example.demo.model.Examination;
import com.example.demo.model.ExaminationStatus;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Users.Patient;
import com.example.demo.repository.ConsultingRepository;
import com.example.demo.repository.ExaminationRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.repository.UserRepository.PharmacistRepository;
import com.example.demo.service.IPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
    @Autowired
    private EmailService emailService;

    
    public PatientService(PatientRepository patientRepository, ExaminationRepository examinationRepository,
            ConsultingRepository consultingRepository, PharmacistRepository pharmacistRepository,EmailService emailService) {
        this.patientRepository = patientRepository;
        this.examinationRepository = examinationRepository;
        this.consultingRepository = consultingRepository;
        this.pharmacistRepository = pharmacistRepository;
        this.emailService=emailService;
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
        SimpleMailMessage mailMessage = new SimpleMailMessage();
       mailMessage.setTo(patient.getEmail());
       mailMessage.setSubject("Reserved examination!");
       mailMessage.setFrom("isatim68@gmail.com");
       mailMessage.setText("Examination succesifully reserved !:"+
       "\ndermatologist:"+examination.getPharmacy().getName()+
       "\ndermatologist:"+examination.getDermatologist().getFirstName()+
       "\ndermatologist:"+examination.getDermatologist().getFirstName()+
       "patient:"+examination.getPatient().getFirstName());

       emailService.sendEmail(mailMessage);
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
        System.out.println("rezervacija pregleda kod farmaceuta servis ");
        Consulting consulting=consultingRepository.findById(consultingId).get();
        consulting.setStatus(ExaminationStatus.scheduled);
        Patient patient=patientRepository.findById(Long.parseLong(patientId)).get();
        if(consulting.getPatient()!=null){
            if(!consulting.getPatient().getId().equals(patient.getId()))
            {
                    consulting.setPatient(patient);
                    consultingRepository.save(consulting);
                    SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(patient.getEmail());
                mailMessage.setSubject("Reserved consulting!");
                mailMessage.setFrom("isatim68@gmail.com");
                mailMessage.setText("Consulting succesifully reserved !:"+
                "\n pharmacist:"+consulting.getPharmacist().getFirstName()+
                "\n patient:"+consulting.getPatient().getFirstName()+
                "patient:"+consulting.getPatient().getFirstName());

                emailService.sendEmail(mailMessage);
        }else{
            System.out.println("Ne moze opet zakazati u istom terminu jer je otkazao !");
            return null;
        }
            }else{
                consulting.setPatient(patient);
                consultingRepository.save(consulting);
                SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(patient.getEmail());
            mailMessage.setSubject("Reserved consulting!");
            mailMessage.setFrom("isatim68@gmail.com");
            mailMessage.setText("Consulting succesifully reserved !:"+
            "\n pharmacist:"+consulting.getPharmacist().getFirstName()+
            "\n patient:"+consulting.getPatient().getFirstName()+
            "patient:"+consulting.getPatient().getFirstName());

            emailService.sendEmail(mailMessage);
            }
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
                
               cd.setExaminationStatus(c.getStatus());
               System.out.println(cd.getExaminationStatus());
                
                ret.add(cd);
                
            }
        }
    }
    System.out.println("pregledii "+ret);
        return ret;
    }

    @Override
    public Consulting cancelConsulting(Long consultingId) {
        Consulting c=consultingRepository.getOne(consultingId);
        if(LocalDate.now().isAfter(c.getDate().minusDays(1))){
            return null;
        }
        c.setStatus(ExaminationStatus.canceled);
        consultingRepository.save(c);
        return c;
    }

    @Override
    public List<ExaminationDTO> getExaminationsByPatient(Long patientId) {
        List<Examination> ex=examinationRepository.findAll();
        List<ExaminationDTO> ret=new ArrayList<>();
        for(Examination e:ex){
            if(e.getPatient()!=null){
                System.out.println("u prvom ifu");
                if(e.getPatient().getId().equals(patientId)){
                    ExaminationDTO ed=new ExaminationDTO();
                    ed.setExaminationId(e.getId());
                    ed.setDate(e.getDate());
                    ed.setDermatologistName(e.getDermatologist().getFirstName().concat(e.getDermatologist().getLastName()));
                    ed.setPharmacyName(e.getPharmacy().getName());
                    ed.setDermatologistRate(e.getDermatologist().getMark());
                    ed.setExaminationStatus(e.getStatus());
                    System.out.println("ed status "+ed.getExaminationStatus());
                    ed.setPrice(e.getPrice());
                    ret.add(ed);
                }
            }
        }
        System.out.println("pronasao preglede kod pacijenta "+patientId+" "+ret);
        return ret;
    }

    @Override
    public Examination cancelExamination(Long examinationId) {
        Examination ex=examinationRepository.findById(examinationId).get();
        if(LocalDate.now().isAfter(ex.getDate().minusDays(1))){
            return null;
        }
        ex.setStatus(ExaminationStatus.canceled);
        examinationRepository.save(ex);
        return null;
    }
}
