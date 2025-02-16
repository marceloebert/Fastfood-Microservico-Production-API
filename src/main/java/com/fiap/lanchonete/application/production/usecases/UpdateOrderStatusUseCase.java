package com.fiap.lanchonete.application.production.usecases;

import com.fiap.lanchonete.application.production.gateways.ProductionGateway;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderStatusUseCase {

    private final ProductionGateway productionGateway;

    public UpdateOrderStatusUseCase(ProductionGateway productionGateway) {
        this.productionGateway = productionGateway;
    }

    public void execute(String orderId, OrderState state) {
        productionGateway.updateOrderState(orderId, state);
    }
}
