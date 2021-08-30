package com.example.demo.service;

import com.example.demo.dto.PharmacyPromotionDTO;
import com.example.demo.model.PharmacyPromotion;
import com.example.demo.repository.PharmacyPromotionRepository;
import com.example.demo.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@RestController
@Service
public class PharmacyPromotionService implements IPharmacyPromotionService{

    @Autowired
    PharmacyPromotionRepository pharmacyPromotionRepository;

   @Autowired
    EmailService emailService;

    @Override
    public List<PharmacyPromotion> getAllPromotions()
    {
        List<PharmacyPromotion> promotionsList = pharmacyPromotionRepository.findAll();
        return promotionsList;
    }

   // @Override
    //@GetMapping(value="api/get")
    public boolean isFirst()
    {
        boolean temp = true;
        List<PharmacyPromotion> promotionList = getAllPromotions();
        for(PharmacyPromotion p : promotionList)
        {
                if(p.getId() != 0)
                {
                    temp = false;
                }

        }
        return temp;
    }
    //@GetMapping(value="api/get")
    @Override
    public Integer returnLastIndex()
    {
        Integer temp = 0;
        List<PharmacyPromotion> promotionList = getAllPromotions();
        for(PharmacyPromotion p : promotionList)
        {
            temp++;
        }
        return temp;
    }
    //int id, String medName, int pharmacyId, int priceBefore, int priceAfter, String description, String startDate, String endDate
    //@PostMapping(value="api/get")
    @Override
    public void savePromotion(PharmacyPromotion promotion)
    {
        //PharmacyPromotionDTO promotionDTO = new PharmacyPromotionDTO(id, medName, pharmacyId, priceBefore, priceAfter,  startDate, endDate, description);
        //pharmacyPromotionRepository.save(promotionDTO);
        PharmacyPromotion p = new PharmacyPromotion();
        p.setId(promotion.getId());
        p.setMedicineName(promotion.getMedicineName());
        p.setPharmacyId(promotion.getPharmacyId());
        p.setPriceBefore(promotion.getPriceBefore());
        p.setPriceAfter(promotion.getPriceAfter());
        p.setDescription(promotion.getDescription());
        p.setStartDate(promotion.getStartDate());
        p.setEndDate(promotion.getEndDate());
        pharmacyPromotionRepository.save(p);
        SimpleMailMessage email = new SimpleMailMessage();



        /*PharmacyPromotion promotion = new PharmacyPromotion();
        promotion.setId(id);
        promotion.setMedicineName(medName);
        promotion.setPharmacyId(pharmacyId);
        promotion.setPriceBefore(priceBefore);
        promotion.setPriceAfter(priceAfter);
        promotion.setStartDate(startDate);
        promotion.setEndDate(endDate);
        promotion.setDescription(description);
        pharmacyPromotionRepository.save(promotion); */
    }

}
