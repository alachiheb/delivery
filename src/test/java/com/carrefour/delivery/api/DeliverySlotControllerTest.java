package com.carrefour.delivery.api;

import com.carrefour.delivery.model.DeliveryType;
import com.carrefour.delivery.model.DeliverySlot;
import com.carrefour.delivery.model.DeliverySlotDto;
import com.carrefour.delivery.repository.DeliverySlotRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DeliverySlotControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeliverySlotRepository deliverySlotRepository;
    @Test
    void postDeliverySlot(@Autowired MockMvc mockMvc) throws Exception{
        DeliverySlotDto deliverySlotDto = DeliverySlotDto
                .builder()
                .deliveryTime("time")
                .deliveryDay("day")
                .available(true)
                .userId("userId")
                .build();
        mockMvc.perform(
                        post("/api/deliverySlots")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(deliverySlotDto)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void findAllDeliverySlotsOK(@Autowired MockMvc mockMvc) throws Exception{

        deliverySlotRepository.save(returnDeliverySlot(DeliveryType.DELIVERY,"mardi","12-14",true,"martin"));
        deliverySlotRepository.save(returnDeliverySlot(DeliveryType.DELIVERY,"mercredi","12-14",true,"Dupond"));

        mockMvc.perform(get("/api/deliverySlots"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$[0].deliveryType").value("DELIVERY"));
    }

    @Test
    void findDeliverySlotsByUserIdOK(@Autowired MockMvc mockMvc) throws Exception{
        deliverySlotRepository.deleteAll();
        deliverySlotRepository.save(returnDeliverySlot(DeliveryType.DELIVERY,"mercredi","12-14",true,"Dupond"));
        mockMvc.perform(get("/api/deliverySlots/Dupond"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("userId").value("Dupond"));
    }

    private DeliverySlot returnDeliverySlot(DeliveryType deliveryType, String deliveryDay, String deliveryTime, boolean available, String userId){
        DeliverySlot deliverySlot = new DeliverySlot();
        deliverySlot.setDeliveryType( deliveryType);
        deliverySlot.setDeliveryDay(deliveryDay);
        deliverySlot.setDeliveryTime(deliveryTime);
        deliverySlot.setAvailable(available);
        deliverySlot.setUserId(userId);
        return deliverySlot;
    }

}
