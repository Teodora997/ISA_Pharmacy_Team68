package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineReservation;
import com.example.demo.model.MedicineReservationStatus;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Users.Patient;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.MedicineReservationRepository;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.service.MedicineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    MedicineRepository medicineRepository;
    
    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    MedicineReservationRepository medicineReservationRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PharmacyStorageService pharmacyStorageService;
    @Autowired
    EmailService emailService;
    

    public MedicineServiceImpl(MedicineRepository medicineRepository, PharmacyRepository pharmacyRepository,
            MedicineReservationRepository medicineReservationRepository, PatientRepository patientRepository, PharmacyStorageService pharmacyStorageService,EmailService emailService) {
        this.medicineRepository = medicineRepository;
        this.pharmacyRepository = pharmacyRepository;
        this.medicineReservationRepository = medicineReservationRepository;
        this.patientRepository = patientRepository;
        this.pharmacyStorageService=pharmacyStorageService;
        this.emailService=emailService;
    }

    @Override
    public List<Medicine> findAllMedicines() {
       List<Medicine> medicines=medicineRepository.findAll();
       return medicines;
    }

    @Override
    public Medicine addMedicine(MedicineDTO m) {
        Medicine medicine=new Medicine();
        System.out.println("ID LIJEKA: "+m.getId());
        Long id=Long.parseLong(m.getId());
        System.out.println("LONG ID LIJEKA: "+id);
        
        Medicine m1=findById(id);
        if(m1==null){
            
            medicine.setId(Long.parseLong(m.getId()));
            medicine.setName(m.getName());
            medicine.setType(m.getType());
            medicine.setForm(m.getForm());
            medicine.setIngredients(m.getIngredients());
            medicine.setRegime(m.getRegime());
            medicine.setProducer(m.getProducer());
            medicine.setAdditional(m.getAdditional());
            medicine.setPoints(Integer.parseInt(m.getPoints()));
           

            medicineRepository.save(medicine);
            return medicine;
        }else{
            return null;
        }
    }

    @Override
    public Medicine findById(Long id) {
        try {
            Medicine medicine=medicineRepository.findById(id).get();
            return medicine;
        } catch (NoSuchElementException e) {
           return null;
        }
    }

    @Override
    public List<Medicine> addAlternatives(ArrayList<String> alternativesId, String id) {
        List<Medicine> alternatives = new ArrayList<Medicine>();
        Long mId=Long.parseLong(id);
       Medicine medicine =findById(mId);
       if(medicine!=null){
           for(String altId : alternativesId){
               Long aId=Long.parseLong(altId);
               Medicine alt = findById(aId);
               if(alt!=null){
                    medicine.getAlternative().add(alt);
                    alternatives.add(alt);
               }

           }
           medicineRepository.save(medicine);
           return alternatives;
       }



        return null;
    }

    @Override
    public List<Medicine> searchMedicines(String name) {
        List<Medicine> medicines=findAllMedicines();
        List<Medicine> ret=new ArrayList<>();
        for(Medicine m1:medicines){
            ret.add(m1);
        }
        System.out.println("PRETRAGA ->NAZIV "+name);
        for(Medicine m:medicines){
            if (!name.equals("all")) {
                if (!m.getName().toLowerCase().equals(name.toLowerCase())) {
                    // and it is in the ret list
                    if (ret.contains(m)) {
                        // remove it from the ret list
                        ret.remove(m);
                    }
                }
            }
        }

System.out.println("REZULTAT "+ret);
        return ret;
    }

    @Override
    public List<MedicineDTO> filterMedicines(List<MedicineDTO> medicines,String type) {
        //List<Medicine> medicines=findAllMedicines();
        List<MedicineDTO> ret=new ArrayList<>();
        for(MedicineDTO m1:medicines){
            ret.add(m1);
        }
        System.out.println("PRETRAGA ->TIP "+type);
        for(MedicineDTO m:medicines){
            if (!type.equals("all")) {
                if (!m.getForm().toLowerCase().equals(type.toLowerCase())) {
                    // and it is in the ret list
                    if (ret.contains(m)) {
                        // remove it from the ret list
                        ret.remove(m);
                    }
                }
            }
        }

System.out.println("REZULTAT "+ret);
        return ret;
    }

    @Override
    public MedicineReservationDTO makeReservation(MedicineReservationDTO med, String patientId) {
        MedicineReservation mr=new MedicineReservation();
        Medicine m=medicineRepository.findById(med.getMedicineId()).get();
        Pharmacy p=pharmacyRepository.findById(med.getPharmacyId()).get();
        Patient pat=patientRepository.findById(Long.parseLong(patientId)).get();
        Boolean available=pharmacyStorageService.checkAvailability(m.getId(), p.getId());

        if(med.getDate().isBefore(LocalDate.now())){
            System.out.println("ne mozes izabrati taj datum!");
            return null;
        }
        if(available){
            System.out.println("dostupan u ifu");
        mr.setMedicineId(med.getMedicineId());
        mr.setMedicineName(m.getName());
        mr.setPharmacyId(med.getPharmacyId());
        mr.setPharmacyName(p.getName());
        mr.setPickUpDate(med.getDate());
        mr.setPatientId(Long.parseLong(patientId));
        mr.setStatus(MedicineReservationStatus.RESERVED);
        mr.setReservationCode( UUID.randomUUID().toString());
        mr.setPatientEmail(pat.getEmail());
        //ovo je jer vracam
        med.setMedicineName(m.getName());
        med.setStatus(mr.getStatus());
        med.setCode(mr.getReservationCode());

       
        pharmacyStorageService.updateStorage(mr.getMedicineId(), mr.getPharmacyId());
        medicineReservationRepository.save(mr);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(pat.getEmail());
        mailMessage.setSubject("Reserved medicine!");
        mailMessage.setFrom("isatim68@gmail.com");
        mailMessage.setText("Medicine succesifully reserved :"+
        "\n reservation code:"+mr.getReservationCode()+
        "\n pharmacy:"+mr.getPharmacyName()+
        "\n patient:"+pat.getFirstName().concat(pat.getLastName())+
        "\n medicine:"+mr.getMedicineName());

        emailService.sendEmail(mailMessage);
        return med;
    }
    System.out.println("nije dostupan i vrati null");
        return null;
  
    }

    @Override
    public List<MedicineReservationDTO> getReservationsByPatient(Long patientId) {
        List<MedicineReservationDTO> ret=new ArrayList<>();
        List<MedicineReservation> allReservations=medicineReservationRepository.findAll();
        for(MedicineReservation mr:allReservations){
        System.out.println("u foru "+mr.getMedicineId());
            if(mr.getPatientId().equals(patientId)){
                System.out.println("if-pacijent ima rezervaciju");
                MedicineReservationDTO md=new MedicineReservationDTO();
                md.setId(mr.getId());
                md.setMedicineId(mr.getMedicineId());
                md.setMedicineName(mr.getMedicineName());
                md.setPharmacyName(mr.getPharmacyName());
                md.setPharmacyId(mr.getPharmacyId());
                md.setDate(mr.getPickUpDate());
                md.setCode(mr.getReservationCode());
                md.setStatus(mr.getStatus());
                ret.add(md);
                
            }
        }
        //penaltyForReservations(ret, patientId);
        System.out.println("REZERVCIJEEE "+ret);
        return ret;
    }
    //OVO DODATI POSLE
     public void penaltyForReservations(List<MedicineReservationDTO> md,Long patientId){
         System.out.println("PENALI");
        Patient p=patientRepository.findById(patientId).get();
        for(MedicineReservationDTO m:md){
            if(m.getDate().isBefore(LocalDate.now()) && !m.getStatus().equals(MedicineReservationStatus.DONE)){
                System.out.println("setuje penale");
                p.setPenals(p.getPenals()+1);
            }
        }
        patientRepository.save(p);
     }
    @Override
    public MedicineReservation cancelReservation(MedicineReservationDTO med) {
        MedicineReservation m=medicineReservationRepository.findById(med.getId()).get();
        if(LocalDate.now().isAfter(m.getPickUpDate().minusDays(1)) || m.getStatus().equals(MedicineReservationStatus.CANCELED)|| m.getStatus().equals(MedicineReservationStatus.DONE)){
           
            System.out.println("NE MOZE! ");
            return null;
        }  
        pharmacyStorageService.updateAfterCancel(m.getMedicineId(), m.getPharmacyId());
        m.setStatus(MedicineReservationStatus.CANCELED);
        medicineReservationRepository.save(m);
        return m;
    }

}
