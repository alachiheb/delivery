package com.carrefour.delivery.repository;

import com.carrefour.delivery.model.DeliverySlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverySlotRepository extends JpaRepository<DeliverySlot, Long> {
    public DeliverySlot findDeliverySlotByUserId(String userId);
}
