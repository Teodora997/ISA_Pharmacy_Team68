package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.ConfirmationToken;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long>{
    ConfirmationToken findByToken(String token);
}
