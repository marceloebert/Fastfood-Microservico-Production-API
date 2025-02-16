package com.fiap.lanchonete;

import com.fiap.lanchonete.entities.orders.enums.OrderState;
import com.fiap.lanchonete.infrastructure.production.repository.ProductionStatusRepository;
import com.fiap.lanchonete.application.production.gateways.ProductionGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductionGatewayImplTest {

    @Mock
    private ProductionStatusRepository productionStatusRepository;

    private ProductionGatewayImpl productionGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productionGateway = new ProductionGatewayImpl(productionStatusRepository);
    }

    @Test
    void testGetOrderState() {
        String orderId = "123";
        when(productionStatusRepository.getOrderState(orderId)).thenReturn(Optional.of("PENDING"));

        Optional<OrderState> result = productionGateway.getOrderState(orderId);

        assertTrue(result.isPresent());
        assertEquals(OrderState.PENDING, result.get());
        verify(productionStatusRepository, times(1)).getOrderState(orderId);
    }

    @Test
    void testUpdateOrderState() {
        String orderId = "123";
        productionGateway.updateOrderState(orderId, OrderState.FINISHED);
        verify(productionStatusRepository, times(1)).updateOrderState(orderId, "DONE");
    }

    @Test
    void testCreateOrderState() {
        String orderId = "123";
        productionGateway.createOrderState(orderId, OrderState.PENDING);
        verify(productionStatusRepository, times(1)).createOrderState(orderId, "PENDING");
    }
}
