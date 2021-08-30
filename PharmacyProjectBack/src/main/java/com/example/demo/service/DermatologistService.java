package com.example.demo.service;


import com.example.demo.model.DermaObj;
import com.example.demo.model.Examination;
import com.example.demo.model.Users.Dermatologist;
import com.example.demo.repository.ExaminationRepository;
import com.example.demo.repository.UserRepository.DermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/dermatologist")
public class DermatologistService {

    @Autowired
    DermatologistRepository dermatologistRepository;

    @Autowired
    ExaminationRepository examinationRepository;



    @GetMapping(value = "/get")
    public List<Dermatologist> getAllDermatologists()
    {
        List<Dermatologist> list = dermatologistRepository.findAll();
        return list;
    }

    @GetMapping(value = "/get3")
    public List<Examination> getExaminations()
    {
        List<Examination> list = examinationRepository.findAll();
        return  list;
    }

   /* @GetMapping(value = "/get2")
    public DermaObj getDermatologist(String name, String surname)
    {
            Dermatologist temp = new Dermatologist();
            List<Dermatologist> list = getAllDermatologists();
            for(Dermatologist d : list)
            {
                if(d.getFirstName().toLowerCase().equals(name.toLowerCase()) && d.getLastName().toLowerCase().equals(surname.toLowerCase()))
                {
                    temp = d;

                }
            }


            return temp;
    } */


}
