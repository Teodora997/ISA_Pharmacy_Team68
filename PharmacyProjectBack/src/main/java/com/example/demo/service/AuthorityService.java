package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Users.Authority;

public interface AuthorityService {
    List<Authority> findById(Long id);
    List<Authority> findByName(String name);
}
