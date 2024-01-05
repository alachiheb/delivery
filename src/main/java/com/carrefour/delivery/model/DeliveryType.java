package com.carrefour.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryType {

    DRIVE ("DRIVE"), DELIVERY("DELIVERY"), DELIVERY_TODAY ("DELIVERY_TODAY"), DELIVERY_ASAP("DELIVERY_ASAP");

    private final String typeDelivery;
}
