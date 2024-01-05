package com.carrefour.delivery.service;


import com.carrefour.delivery.exception.DeliverySlotExceptionMessage;
import com.carrefour.delivery.exception.DeliverySlotNotFoundException;
import com.carrefour.delivery.model.DeliverySlot;
import com.carrefour.delivery.repository.DeliverySlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public record DeliverySlotService (DeliverySlotRepository deliverySlotRepository){

    public List<DeliverySlot> getAllDeliverySlots(){
        return deliverySlotRepository.findAll();
    }

    public DeliverySlot getDeliverySlotByUserId(String userId){
        if (deliverySlotRepository.findDeliverySlotByUserId(userId) == null){
            throw new DeliverySlotNotFoundException(DeliverySlotExceptionMessage.DELIVERY_SLOT_NOT_FOUND.toErrorMessage());
        }
        return deliverySlotRepository.findDeliverySlotByUserId(userId);

    }
    public DeliverySlot addDeliverySlot(DeliverySlot deliverySlot){
        //TODO
        // test if slot is available
        return deliverySlotRepository.save(deliverySlot);
    }
}
