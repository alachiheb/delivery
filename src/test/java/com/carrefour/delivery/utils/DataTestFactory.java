package com.carrefour.delivery.utils;

import com.carrefour.delivery.model.DeliveryType;
import com.carrefour.delivery.model.DeliverySlot;

public class DataTestFactory {

    public static DeliverySlot returnDeliverySlot(DeliveryType deliveryType, String deliveryDay, String deliveryTime, boolean available, String userId){
        DeliverySlot deliverySlot = new DeliverySlot();
        deliverySlot.setDeliveryType( deliveryType);
        deliverySlot.setDeliveryDay(deliveryDay);
        deliverySlot.setDeliveryTime(deliveryTime);
        deliverySlot.setAvailable(available);
        deliverySlot.setUserId(userId);
        return deliverySlot;
    }
}
