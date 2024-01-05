package com.carrefour.delivery.service;

import com.carrefour.delivery.model.DeliveryType;
import com.carrefour.delivery.model.DeliverySlot;
import com.carrefour.delivery.repository.DeliverySlotRepository;
import com.carrefour.delivery.utils.DataTestFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeliverySlotServiceTest
{
    @Mock
    private DeliverySlotRepository deliverySlotRepository;

    @InjectMocks
    private DeliverySlotService deliverySlotService;
    @Test
    void postDeliverySlotOk()  {
        DeliverySlot deliverySlot = DataTestFactory.returnDeliverySlot(DeliveryType.DELIVERY,"mardi","12-14",true,"martin");
        when(deliverySlotRepository.save(any())).thenReturn(deliverySlot);
        DeliverySlot deliverySlotResponse = deliverySlotService.addDeliverySlot(deliverySlot);
        assertEquals(deliverySlotResponse.getDeliveryDay(), deliverySlot.getDeliveryDay());
    }

    @Test
    void findAllDeliverySlotsOk()  {
        DeliverySlot deliverySlot1 = DataTestFactory.returnDeliverySlot(DeliveryType.DELIVERY,"mardi","12-14",true,"martin");
        DeliverySlot deliverySlot2 = DataTestFactory.returnDeliverySlot(DeliveryType.DELIVERY,"mercredi","12-14",true,"dupond");
        when(deliverySlotRepository.findAll()).thenReturn(List.of(deliverySlot1,deliverySlot2));
        List<DeliverySlot> deliverySlotResponseList = deliverySlotService.getAllDeliverySlots();
        assertEquals(deliverySlotResponseList.size(), 2);
    }

    @Test
    void findAllDeliverySlotByUserId()  {
        DeliverySlot deliverySlot1 = DataTestFactory.returnDeliverySlot(DeliveryType.DELIVERY,"mardi","12-14",true,"martin");
        when(deliverySlotRepository.findDeliverySlotByUserId("martin")).thenReturn(deliverySlot1);
        DeliverySlot deliverySlotResponse= deliverySlotService.getDeliverySlotByUserId("martin");
        assertEquals(deliverySlotResponse.getUserId(), "martin");
    }
}
