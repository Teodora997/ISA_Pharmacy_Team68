package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.WorkTime;
import com.example.demo.service.WorkTimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/worktime")
public class WorkTimeController {
    @Autowired
    WorkTimeService workTimeService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<WorkTime>> getAllWorkTimes(){
        List<WorkTime> worktimes=workTimeService.findAllWorkTimes();
        return new ResponseEntity<>(worktimes,HttpStatus.OK);
    }
}
