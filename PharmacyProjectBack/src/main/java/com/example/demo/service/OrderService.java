package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderMedicinesDTO;
import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderMedicines;

public interface OrderService {
    List<OrderMedicinesDTO> getWaitingOrders();
    List<OrderItem> getItemsFromOrder(Long orderId);
}
