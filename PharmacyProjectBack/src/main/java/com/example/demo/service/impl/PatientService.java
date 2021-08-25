package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.ConsultingDTO;
import com.example.demo.dto.ExaminationDTO;
import com.example.demo.model.Complaint;
import com.example.demo.model.Consulting;
import com.example.demo.model.Examination;
import com.example.demo.model.ExaminationStatus;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Users.Dermatologist;
import com.example.demo.model.Users.Patient;
import com.example.demo.model.Users.Pharmacist;
import com.example.demo.model.Users.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ConsultingRepository;
import com.example.demo.repository.ExaminationRepository;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.UserRepository.DermatologistRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.repository.UserRepository.PharmacistRepository;
import com.example.demo.service.IPatientService;
import com.example.demo.service.UserService;

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
    private MedicineRepository medicineRepository;
    @Autowired
    private EmailService emailService;

    @Autowired 
    UserService userService;

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    DermatologistRepository dermatologistRepository;

    
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
        
        List<ExaminationDTO> ex=getExaminationsByPatient(Long.parseLong(patientId));
        Boolean patientAvailable=true;
        Examination examination=examinationRepository.findById(examinationId).get();
        List<ConsultingDTO> cons=getConsultingsByPatient(Long.parseLong(patientId));
        for(ConsultingDTO cd:cons){
            if(cd.getDate().isEqual(examination.getDate()) && cd.getTime().equals(examination.getTime())){
                System.out.println("pacijent je zauzet EXAMINATIONS");
                patientAvailable=false;
            }
        }

        for(ExaminationDTO cd:ex){
            if(cd.getDate().isEqual(examination.getDate()) && cd.getTime().equals(examination.getTime())){
                System.out.println("pacijent je zauzet EXAMINATIONS");
                patientAvailable=false;
            }
        }
        if(patientAvailable){
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
        }else{
            System.out.println("zauzet pacijent examinations");
            return null;
        }
    }

    @Override
    public List<ConsultingDTO> getPharmaciesForConsulting(LocalDate date, String time) {
        if(date.isBefore(LocalDate.now())){
            return null;
        }
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
    public Integer makeConsulting(String patientId, Long consultingId) {
        System.out.println("rezervacija pregleda kod farmaceuta servis ");
        Consulting consulting=consultingRepository.findById(consultingId).get();
        List<ExaminationDTO> allEx=getExaminationsByPatient(Long.parseLong(patientId));
        Boolean patientAvailable=true;
        for(ExaminationDTO ex:allEx){
            System.out.println("u foru "+ex.getDate()+" "+consulting.getDate()+ex.getTime()+" "+consulting.getTime());
            if(ex.getDate().compareTo(consulting.getDate())==0 && ex.getTime().equals(consulting.getTime())){
                System.out.println("pacijent je zauzet");
                patientAvailable=false;
            }
        }

        List<ConsultingDTO> cons=getConsultingsByPatient(Long.parseLong(patientId));
        for(ConsultingDTO cd:cons){
            if(cd.getDate().isEqual(consulting.getDate()) && cd.getTime().equals(consulting.getTime())){
                System.out.println("pacijent je zauzet EXAMINATIONS");
                patientAvailable=false;
            }
        }
        Patient patient=patientRepository.findById(Long.parseLong(patientId)).get();
        if(patientAvailable){
        if(consulting.getPatient()!=null){
            if(!consulting.getPatient().getId().equals(patient.getId()))
            {
                    consulting.setStatus(ExaminationStatus.scheduled);               
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
                return 1;
        }else{
            System.out.println("Ne moze opet zakazati u istom terminu jer je otkazao !");
            return null;
        }
            }else{
                consulting.setStatus(ExaminationStatus.scheduled);               
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
        
                return 1;
            }
        }else{
            System.out.println("Pacijent ima zakazan pregled tada!");
            return null;
        }
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
                    ed.setDermatologistId(e.getDermatologist().getId());
                    ed.setDate(e.getDate());
                    ed.setTime(e.getTime());
                    ed.setPharmacyId(e.getPharmacy().getId());
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

    @Override
    public Integer makeComplaint(String patientId, Long userId,String text) {
        //Long uId=Long.parseLong(userId);
        Long pId=Long.parseLong(patientId);
        User u=userService.findById(userId);

        Patient p=(Patient)userService.findById(pId);
        System.out.println("PACIJENT SERVIS PISANJE ZALBE PACIJENT: "+p.getFirstName() +" ZA: "+u.getFirstName());
        Complaint complaint= new Complaint();
        complaint.setDate(LocalDate.now());
        complaint.setIsAnswered(false);
        complaint.setName(u.getFirstName()+" "+u.getLastName());
        complaint.setText(text);
        complaint.setPatient(p);

        complaintRepository.save(complaint);

        return 1;
    }

    @Override
    public List<Pharmacy> getPharmaciesForComplaint(Long patientId) {
       System.out.println("U SERVISU ZA APOTEKE ZA ZALBY: "+ patientId);
       List<ConsultingDTO> cons=getConsultingsByPatient(patientId);
       List<ExaminationDTO> exams=getExaminationsByPatient(patientId);

       List<Pharmacy> pharmacies=new ArrayList<Pharmacy>();

       for(ConsultingDTO c:cons){
           Pharmacy p=pharmacyRepository.findById(c.getPharmacyId()).get();
            System.out.println("u prvom foru: "+c.getPharmacyId()+" "+c.getPharmacyName());
           pharmacies.add(p);
       }
       for(ExaminationDTO e:exams){
        Pharmacy p=pharmacyRepository.findById(e.getPharmacyId()).get();
        System.out.println("u drugom foru: "+e.getPharmacyId()+" "+e.getPharmacyName());
        pharmacies.add(p);
        }

        List<Pharmacy> pharmacies1= new ArrayList<>(new HashSet<>(pharmacies));

        

        return pharmacies1;
    }

    @Override
    public Integer makeComplaintPharmacy(String patientId, Long pharmacyId, String text) {
        Long pId=Long.parseLong(patientId);
        Pharmacy ph=pharmacyRepository.findById(pharmacyId).get();

        Patient p=(Patient)userService.findById(pId);
        System.out.println("PACIJENT SERVIS PISANJE ZALBE PACIJENT: "+p.getFirstName() +" ZA: "+ ph.getName());
        Complaint complaint= new Complaint();
        complaint.setDate(LocalDate.now());
        complaint.setIsAnswered(false);
        complaint.setName(ph.getName());
        complaint.setText(text);
        complaint.setPatient(p);

        complaintRepository.save(complaint);

        return 1;
    }

    @Override
    public Double rateUser(Long userId, Double mark) {
        Pharmacist ph=pharmacistRepository.findById(userId).orElse(null);
        Dermatologist d=dermatologistRepository.findById(userId).orElse(null);
        Double newMark;
        if(ph!=null){
            newMark=(ph.getMark()+mark)/2;
            ph.setMark(newMark);
            pharmacistRepository.save(ph);
        }else{
            newMark=(d.getMark()+mark)/2;
            d.setMark(newMark);
            dermatologistRepository.save(d);
        }
        return newMark;
    }

    @Override
    public Double rateMedicine(Long medicineId, Double mark) {
        Medicine m=medicineRepository.findById(medicineId).get();
        Double newMark;
        newMark=(m.getMark()+mark)/2;
        m.setMark(newMark);
        medicineRepository.save(m);
        return newMark;
    }

    @Override
    public Double ratePharmacy(Long pharmacyId, Double mark) {
        Pharmacy p=pharmacyRepository.findById(pharmacyId).get();
        Double newMark;
        newMark=(p.getMark()+mark)/2;
        p.setMark(newMark);
        pharmacyRepository.save(p);
        return newMark;
    }

    @Override
    public Set<Pharmacy> getSubscribedPharmacies(Long patientId) {
        Patient p=patientRepository.findById(patientId).get();
        Set<Pharmacy> pharmacies=p.getSubPharmacies();
        return pharmacies;
    }

    @Override
    public Pharmacy subscribe(Long patientId, Long pharmacyId) {
        System.out.println("SERVIS SUBSCRIBE");
        Patient p=patientRepository.findById(patientId).get();
        Pharmacy ps=pharmacyRepository.findById(pharmacyId).get();
        Set<Pharmacy> subPharmacies=p.getSubPharmacies();
        for(Pharmacy ph:subPharmacies){
            if(ph.getId().equals(pharmacyId)){
                System.out.println("Vec pretplacen!");
                return null;
            }
        }
                subPharmacies.add(ps);
                p.setSubPharmacies(subPharmacies);
                patientRepository.save(p);
         return ps;
    }

    @Override
    public Pharmacy unsubscribe(Long patientId, Long pharmacyId) {
        System.out.println("UNSUBSCRIBE");
        Patient p=patientRepository.findById(patientId).get();
        Pharmacy ps=pharmacyRepository.findById(pharmacyId).get();
        Set<Pharmacy> subPharmacies=p.getSubPharmacies();      
        subPharmacies.remove(ps);
        p.setSubPharmacies(subPharmacies);
        patientRepository.save(p);
        return ps;
    }

    @Override
    public ArrayList<ExaminationDTO> sort(ArrayList<ExaminationDTO> sortAppointments, String sortType) {
       
        if(sortType.equals("RATE")){
            sortAppointments.sort(Comparator.comparingDouble(ExaminationDTO:: getDermatologistRate));
            return sortAppointments;
        }else if(sortType.equals("PRICE")){
            sortAppointments.sort(Comparator.comparingDouble(ExaminationDTO:: getPrice));
            return sortAppointments;
        }
        return null;
    }
}
