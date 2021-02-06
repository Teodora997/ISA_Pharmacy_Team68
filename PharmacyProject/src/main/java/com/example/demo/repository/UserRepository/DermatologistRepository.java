package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.Dermatologist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Integer> {
    
}
