package com.carrefour.delivery.api;



import com.carrefour.delivery.mapper.DeliverySlotMapper;
import com.carrefour.delivery.model.DeliverySlot;
import com.carrefour.delivery.model.DeliverySlotDto;
import com.carrefour.delivery.model.DeliverySlotResponse;
import com.carrefour.delivery.service.DeliverySlotService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public record DeliverySlotController(DeliverySlotService deliverySlotService, DeliverySlotMapper deliverySlotMapper) {

    @GetMapping("/deliverySlots")
    public ResponseEntity<List<DeliverySlot>>  findAllDeliverySlots() {
        List<DeliverySlot> sortedList = deliverySlotService.getAllDeliverySlots().stream()
                .sorted(Comparator.comparing(DeliverySlot::getUserId))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sortedList);
    }
    @GetMapping("/deliverySlots/{userId}")
    public ResponseEntity<DeliverySlot>  findDeliverySlotsByUserId(@PathVariable @NotNull String userId) {
        DeliverySlot deliverySlot = deliverySlotService.getDeliverySlotByUserId(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deliverySlot);
    }

    @PostMapping("/deliverySlots")
    public ResponseEntity<DeliverySlotResponse>  saveDeliverySlot(@Valid @RequestBody DeliverySlotDto deliverySlotDto) {

        DeliverySlot deliverySlot = deliverySlotService.addDeliverySlot(deliverySlotMapper.toDeliverySlot(deliverySlotDto));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deliverySlotMapper.toDeliverySlotResponse(deliverySlot));
    }














}

