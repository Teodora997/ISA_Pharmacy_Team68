package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
}