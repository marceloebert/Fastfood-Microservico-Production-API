package com.fiap.lanchonete.application.production.gateways;

import com.fiap.lanchonete.entities.orders.enums.OrderState;
import java.util.Optional;

public interface ProductionGateway {
    Optional<OrderState> getOrderState(String orderId);
    void updateOrderState(String orderId, OrderState state);
    void createOrderState(String orderId, OrderState initialState);
}
