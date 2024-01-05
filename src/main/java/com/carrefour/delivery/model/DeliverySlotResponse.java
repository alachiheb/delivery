package com.carrefour.delivery.model;

import lombok.Builder;


@Builder
public record DeliverySlotResponse(DeliveryType deliveryType
        , String deliveryDay
        , String deliveryTime
        , Boolean available
        , String userId){

}
