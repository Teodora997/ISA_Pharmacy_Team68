package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineReservation;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.MedicineService;

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
@RequestMapping(value="api/medicines")
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @Autowired
    MedicineRepository medicineRepository;

    @PostMapping(value = "/addMedicine")
    public ResponseEntity<Medicine> addMedicine(@RequestBody MedicineDTO medicine){
        Medicine m=medicineService.addMedicine(medicine);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @PostMapping(value="/addAlternatives/{id}")
    public ResponseEntity<?> addAlternatives(@RequestBody ArrayList<String> alternativesId, @PathVariable("id") String id){
    
        List<Medicine> alternatives=medicineService.addAlternatives(alternativesId, id);

        return new ResponseEntity<ArrayList<String>>(alternativesId, HttpStatus.CREATED);
    }

     @GetMapping(value = "/getAllMedicines")
    public ResponseEntity<?> getAllMedicines(){
       List<Medicine> medicines=medicineRepository.findAll();
        return new ResponseEntity<>(medicines,HttpStatus.OK);
    }

    @PostMapping(value = "/searchMedicines")
    public ResponseEntity<List<Medicine>> searchMedicines(@RequestBody String name){
        List<Medicine> medicines=medicineService.searchMedicines(name);
        return new ResponseEntity<>(medicines,HttpStatus.OK);
    }

    @PostMapping(value = "/filterMedicines/{type}")
    public ResponseEntity<List<MedicineDTO>> filterMedicines(@RequestBody List<MedicineDTO> medicines,@PathVariable("type") String type){
        List<MedicineDTO> m=medicineService.filterMedicines(medicines,type);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @PostMapping(value="/makeReservation/{patientId}")
    public ResponseEntity<MedicineReservationDTO> makeReservation(@RequestBody MedicineReservationDTO med,@PathVariable String patientId){
System.out.println("*********make reservation kontroler");
        MedicineReservationDTO md=medicineService.makeReservation(med, patientId);
        if(md!=null){
            return new ResponseEntity<MedicineReservationDTO>(md,HttpStatus.OK);
        }
        return null;
    }

    @GetMapping(value="/getReservationsByPatient/{patientId}")
    public ResponseEntity<List<MedicineReservationDTO>> getReservationsByPatient(@PathVariable String patientId ){
        System.out.println("TRAZI REZERVACIJE OD PACIJENTA "+patientId);
        List<MedicineReservationDTO> ret=new ArrayList<>();
        ret=medicineService.getReservationsByPatient(Long.parseLong(patientId));
        System.out.println("nasao rzervacije "+ret);
        if(ret!=null){
            System.out.println("nasao rezervacije "+ret);
        return new ResponseEntity<List<MedicineReservationDTO>>(ret,HttpStatus.OK);
        }
        return null;
    }
    @PostMapping(value="/cancelReservation")
    public ResponseEntity<MedicineReservation> cancelReservation(@RequestBody MedicineReservationDTO med){
        MedicineReservation mr=medicineService.cancelReservation(med);
        if(mr!=null){
            return new ResponseEntity<MedicineReservation>(mr,HttpStatus.OK);
        }
        return null;
    }
}
