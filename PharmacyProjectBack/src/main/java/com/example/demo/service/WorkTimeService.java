package com.example.demo.service;

import java.util.List;

import com.example.demo.model.WorkTime;
import com.example.demo.repository.WorkTimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkTimeService {
    @Autowired
    WorkTimeRepository workTimeRepository;

    public List<WorkTime> findAllWorkTimes(){
        return workTimeRepository.findAll();
    }
}
