package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.OrderMedicinesDTO;
import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderMedicines;
import com.example.demo.model.OrderOfferStatus;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderMedicinesDTO> getWaitingOrders() {
       List<OrderMedicines> orders1=orderRepository.findAll();

       List<OrderMedicinesDTO> orders=new ArrayList<>();

       for(OrderMedicines o:orders1){
           if(o.getOrderStatus()==OrderOfferStatus.WAITING){
               OrderMedicinesDTO dto=new OrderMedicinesDTO();
               dto.setId(o.getId());
               dto.setOrderStatus(o.getOrderStatus());
               dto.setPharmacyName(o.getPharmacy().getName());
               dto.setTimeLimit(o.getTimeLimit());
               orders.add(dto);
           }
       }
       return orders;
    }

    @Override
    public List<OrderItem> getItemsFromOrder(Long orderId) {
        OrderMedicines order=orderRepository.findById(orderId).get();
        List<OrderItem> items= order.getOrderItems();
        return items;
    }

    
}
