package com.carrefour.delivery.mapper;

import com.carrefour.delivery.model.DeliverySlot;
import com.carrefour.delivery.model.DeliverySlotDto;
import com.carrefour.delivery.model.DeliverySlotResponse;
import org.mapstruct.Mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliverySlotMapper {

    DeliverySlot toDeliverySlot(DeliverySlotDto deliverySlotDto) ;
    DeliverySlotResponse toDeliverySlotResponse(DeliverySlot deliverySlot) ;
}

