package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.DisplayOfferDTO;
import com.example.demo.dto.OfferDTO;
import com.example.demo.model.Offer;
import com.example.demo.model.OrderMedicines;
import com.example.demo.model.OrderOfferStatus;
import com.example.demo.model.Users.Supplier;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OfferRepository offerRepository;

    
    @Override
    public void sendOffer(Long userId,Long orderId, OfferDTO offer) {
      Offer o=new Offer();
      OrderMedicines order=orderRepository.findById(orderId).get();
      Supplier s=(Supplier)userRepository.findById(userId).get();

      o.setTotalPrice(offer.getTotalPrice());
      o.setDeliveryDate(offer.getDeliveryDate());
      o.setOrder(order);
      o.setOfferStatus(OrderOfferStatus.WAITING);
      o.setSupplier(s);
      
      offerRepository.save(o);
        
    }

    @Override
    public List<DisplayOfferDTO> getOffers(Long userId) {
       List<Offer> offers=offerRepository.findAll();

       //Supplier s=(Supplier)userRepository.findById(userId).get();

       List<DisplayOfferDTO> dtos=new ArrayList<>();

       for(Offer o:offers){
            if(o.getSupplier().getId()==userId){
                DisplayOfferDTO d=new DisplayOfferDTO();
                d.setDeliveryDate(o.getDeliveryDate());
                d.setOfferId(o.getId());
                d.setOrderId(o.getOrder().getId());
                d.setPharmacyId(o.getOrder().getPharmacy().getId());
                d.setPharmacyName(o.getOrder().getPharmacy().getName());
                d.setTimeLimit(o.getOrder().getTimeLimit());
                d.setTotalPrice(o.getTotalPrice());
                d.setOfferStatus(o.getOfferStatus());

                dtos.add(d);
            }
       }
        return dtos;
    }

    @Override
    public void changeOffer(Long userId, Long orderId, DisplayOfferDTO offer) {
       Offer o=offerRepository.findById(offer.getOfferId()).get();

       o.setDeliveryDate(offer.getDeliveryDate());
       o.setTotalPrice(offer.getTotalPrice());
        
       offerRepository.save(o);
    }
    
}
