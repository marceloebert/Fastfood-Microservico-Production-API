package com.fiap.lanchonete.application.production.usecases;

import com.fiap.lanchonete.application.production.gateways.ProductionGateway;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderStatusUseCase {

    private final ProductionGateway productionGateway;

    public CreateOrderStatusUseCase(ProductionGateway productionGateway) {
        this.productionGateway = productionGateway;
    }

    public void execute(String orderId, OrderState initialState) {
        productionGateway.createOrderState(orderId, initialState);
    }
}
