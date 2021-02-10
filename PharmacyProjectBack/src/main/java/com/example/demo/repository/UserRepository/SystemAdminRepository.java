package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.SystemAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemAdminRepository extends JpaRepository<SystemAdmin,Integer> {
    
}
