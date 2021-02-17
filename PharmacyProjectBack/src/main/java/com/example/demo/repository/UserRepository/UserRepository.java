package com.example.demo.repository.UserRepository;

import com.example.demo.model.Users.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
}
