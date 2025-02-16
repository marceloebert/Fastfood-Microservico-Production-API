package com.fiap.lanchonete;

import com.fiap.lanchonete.application.production.gateways.ProductionGateway;
import com.fiap.lanchonete.application.production.usecases.CreateOrderStatusUseCase;
import com.fiap.lanchonete.application.production.usecases.GetOrderStatusUseCase;
import com.fiap.lanchonete.application.production.usecases.UpdateOrderStatusUseCase;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UseCasesTest {

    @Mock
    private ProductionGateway productionGateway;

    @InjectMocks
    private CreateOrderStatusUseCase createOrderStatusUseCase;

    @InjectMocks
    private GetOrderStatusUseCase getOrderStatusUseCase;

    @InjectMocks
    private UpdateOrderStatusUseCase updateOrderStatusUseCase;

    @Test
    void testCreateOrderStatus() {
        String orderId = "123";
        createOrderStatusUseCase.execute(orderId, OrderState.PENDING);
        verify(productionGateway, times(1)).createOrderState(orderId, OrderState.PENDING);
    }

    @Test
    void testGetOrderStatus() {
        String orderId = "123";
        getOrderStatusUseCase.execute(orderId);
        verify(productionGateway, times(1)).getOrderState(orderId);
    }

    @Test
    void testUpdateOrderStatus() {
        String orderId = "123";
        updateOrderStatusUseCase.execute(orderId, OrderState.FINISHED);
        verify(productionGateway, times(1)).updateOrderState(orderId, OrderState.FINISHED);
    }
}
