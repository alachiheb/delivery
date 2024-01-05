package com.carrefour.delivery.api;

import com.carrefour.delivery.exception.RestResponseEntityExceptionHandler;
import com.carrefour.delivery.repository.DeliverySlotRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DeliverySlotControllerAdviceTest {
    RestResponseEntityExceptionHandler restResponseEntityExceptionHandler = new RestResponseEntityExceptionHandler();
    @Test
    void handleDeliveryRuntimeException() {
        RuntimeException exception = new RuntimeException("internal server error");
        WebRequest mockWebRequest = mock(WebRequest.class);
        ResponseEntity<Object> response = restResponseEntityExceptionHandler.handleDeliverySlotRuntimeException(exception,mockWebRequest);
        assertEquals(500, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

}
