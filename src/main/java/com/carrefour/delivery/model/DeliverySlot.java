package com.carrefour.delivery.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "slot")
@Data
public class DeliverySlot {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private DeliveryType deliveryType;

    private String deliveryDay;

    private String deliveryTime;

    private Boolean available;

    private String userId;
}
