package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.Patient;


import org.springframework.data.jpa.repository.JpaRepository;



public interface PatientRepository  extends JpaRepository<Patient,Long>{
}
