package com.carrefour.delivery.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;



@Builder
public record DeliverySlotDto (DeliveryType deliveryType
        , @NotBlank(message = "The deliveryDay is required.") String deliveryDay
        , @NotBlank(message = "The deliveryTime is required.") String deliveryTime
        , Boolean available
        , @NotBlank(message = "The userId is required.") String userId){

}
