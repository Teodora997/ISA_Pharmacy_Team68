package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.OrderMedicinesDTO;
import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderMedicines;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/getOrders")
    public ResponseEntity<List<OrderMedicinesDTO>> getOrders(){
        List<OrderMedicinesDTO> orders=orderService.getWaitingOrders();

        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @PostMapping(value = "/getItemsFromOrder")
    public ResponseEntity<List<OrderItem>> getItemsFromOrder(@RequestBody Long orderId){
        List<OrderItem> items=orderService.getItemsFromOrder(orderId);

        return new ResponseEntity<>(items,HttpStatus.OK);
    }
}
