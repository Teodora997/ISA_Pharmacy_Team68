package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.ConsultingDTO;
import com.example.demo.dto.ExaminationDTO;
import com.example.demo.model.Consulting;
import com.example.demo.model.Examination;
import com.example.demo.model.Medicine;
import com.example.demo.model.Users.Patient;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.service.PharmacyService;
import com.example.demo.service.impl.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PharmacyService pharmacyService;
    
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private PatientRepository patientRepository;

public PatientController(PatientService patientService, PharmacyService pharmacyService,
            MedicineRepository medicineRepository, PatientRepository patientRepository) {
        this.patientService = patientService;
        this.pharmacyService = pharmacyService;
        this.medicineRepository = medicineRepository;
        this.patientRepository = patientRepository;
    }


    @GetMapping(value="/getMyAllergies/{id}")
    public ResponseEntity<Set<Medicine>> getMyAllergies(@PathVariable("id") String id){
        
            Set<Medicine> allergies;
            allergies=patientService.getMyAllergies(id);
        return new ResponseEntity<Set<Medicine>>(allergies, HttpStatus.OK);
    }
    @GetMapping(value = "/getAllMedicines")
    public ResponseEntity<List<Medicine>> getAllMedicines(){
        List<Medicine> allMedicines=new ArrayList<>();
        allMedicines=medicineRepository.findAll();
        return new ResponseEntity<List<Medicine>>(allMedicines, HttpStatus.OK);
    }
    @PostMapping(value = "/addAllergy/{idMed}")
    public ResponseEntity<String> addAllergy(@RequestBody String userId,@PathVariable("idMed") String idMed){
        Patient p=patientRepository.findById(Long.parseLong(userId)).get();
       Set<Medicine> allergies=p.getAllergies();
       for(Medicine m:allergies){
           if(m.getId().equals(Long.parseLong(idMed))){
            return new ResponseEntity<>("This allergy already added! ",HttpStatus.OK);
           }
        }
        Medicine medicine=medicineRepository.findById(Long.parseLong(idMed)).get();
        allergies.add(medicine);
        patientRepository.save(p);
        return new ResponseEntity<String>("Allergy added!",HttpStatus.OK);
    }
 
    @GetMapping(value="/getAvailableExaminations/{pharmacyId}")
    public ResponseEntity<List<ExaminationDTO>> getAvailableExaminations(@PathVariable("pharmacyId") Long pharmacyId)
    {   
        List<ExaminationDTO> ex=pharmacyService.getAvailableExaminations(pharmacyId);
        return new ResponseEntity<List<ExaminationDTO>>(ex,HttpStatus.OK);
    }
    
    @PostMapping(value="/makeExamination/{examinationId}")
    public ResponseEntity<Long> makeExamination(@RequestBody String patientId,@PathVariable("examinationId") Long examinationId){

       Long id=patientService.makeExamination(patientId,examinationId);
       if(id!=null){
        return new ResponseEntity<Long>(id,HttpStatus.OK);
    }
    return null;
}
@PostMapping(value="/makeConsulting/{consultingId}")
    public ResponseEntity<Long> makeConsulting(@RequestBody String patientId,@PathVariable("consultingId") Long consultingId){
        System.out.println("rezervise pregled kod farmaceuta -kontroler"+ consultingId+patientId);
       Long id=patientService.makeConsulting(patientId,consultingId);
       if(id!=null){
        return new ResponseEntity<Long>(id,HttpStatus.OK);
    }
    return null;
}
@PostMapping(value = "/getPharmaciesForConsulting/{date}")
    public ResponseEntity<List<ConsultingDTO>> getPharmaciesForConsulting(@RequestBody String time,@PathVariable("date") String date){
       System.out.println("TRAZI APOTEKE SA ZADATIM PARAMETRIMA "+date+time);
        List<ConsultingDTO> ret=patientService.getPharmaciesForConsulting(LocalDate.parse(date), time);
        if(ret!=null){
           //System.out.println(ret.get(0).getPharmacyName());
        return new ResponseEntity<List<ConsultingDTO>>(ret,HttpStatus.OK);
    }else{
        return null;
    }
}
@GetMapping(value = "/getConsultingsByPatient/{patientId}")
    public ResponseEntity<List<ConsultingDTO>> getConsultingsByPatient(@PathVariable("patientId") String patientId){
        System.out.println("TRAZI preglede pd "+patientId);
        List<ConsultingDTO> ret=patientService.getConsultingsByPatient(Long.parseLong(patientId));
        
        return new ResponseEntity<List<ConsultingDTO>>(ret,HttpStatus.OK);
}
@PostMapping(value="/cancelConsulting")
public ResponseEntity<?> cancelConsulting(@RequestBody Long consultingId){
    Consulting c=patientService.cancelConsulting(consultingId);
        return new ResponseEntity<Consulting>(c, HttpStatus.OK);
    
}
@GetMapping(value = "/getExaminationsByPatient/{patientId}")
    public ResponseEntity<List<ExaminationDTO>> getExaminationsByPatient(@PathVariable("patientId") String patientId){
        System.out.println("TRAZI preglede pd "+patientId);
        List<ExaminationDTO> ret=patientService.getExaminationsByPatient(Long.parseLong(patientId));
        for(ExaminationDTO e:ret){
            System.out.println(e.getExaminationStatus());
        }
        return new ResponseEntity<List<ExaminationDTO>>(ret,HttpStatus.OK);
}
@PostMapping(value="/cancelExamination")
public ResponseEntity<?> cancelExamination(@RequestBody Long examinationId){
    Examination c=patientService.cancelExamination(examinationId);
    if(c!=null){
    System.out.println(c.getDermatologist().getFirstName());}
        return new ResponseEntity<Examination>(c, HttpStatus.OK);
    
}
}
