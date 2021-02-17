package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Users.Authority;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.service.AuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findById(Long id) {
        Authority authority=authorityRepository.getOne(id);
        List<Authority> authorities=new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }

    @Override
    public List<Authority> findByName(String name) {
        Authority authority=authorityRepository.findByName(name);
        List<Authority> authorities=new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }
    
}
