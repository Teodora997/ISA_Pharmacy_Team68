package com.example.demo.repository;

import com.example.demo.model.WorkTime;

import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {

}