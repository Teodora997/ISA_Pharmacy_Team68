package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.DisplayOfferDTO;
import com.example.demo.dto.OfferDTO;
import com.example.demo.dto.OrderMedicinesDTO;
import com.example.demo.model.Offer;
import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderMedicines;
import com.example.demo.service.OfferService;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    
    @Autowired
    OrderService orderService;

    @Autowired
    OfferService offerService;

    @PostMapping(value = "/getOrders")
    public ResponseEntity<List<OrderMedicinesDTO>> getOrders(@RequestBody String userId){
        Long id=Long.parseLong(userId);
        List<OrderMedicinesDTO> orders=orderService.getWaitingOrders(id);

        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @PostMapping(value = "/getItemsFromOrder")
    public ResponseEntity<List<OrderItem>> getItemsFromOrder(@RequestBody Long orderId){
        List<OrderItem> items=orderService.getItemsFromOrder(orderId);

        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @PostMapping(value = "/sendOffer/{userId}/{orderId}")
    public ResponseEntity<?> sendOffer(@PathVariable("userId") String userId,@PathVariable("orderId") Long orderId ,@RequestBody OfferDTO offer){
       
        Long id=Long.parseLong(userId);

        offerService.sendOffer(id,orderId,offer);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping(value = "/getOffers")
    public ResponseEntity<List<DisplayOfferDTO>> getOffers(@RequestBody String id){
        Long userId=Long.parseLong(id);

        List<DisplayOfferDTO> offers=offerService.getOffers(userId);

        return new ResponseEntity<>(offers,HttpStatus.OK);
    }
}
