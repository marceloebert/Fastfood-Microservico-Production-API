package com.fiap.lanchonete.application.production.usecases;

import com.fiap.lanchonete.application.production.gateways.ProductionGateway;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOrderStatusUseCase {

    private final ProductionGateway productionGateway;

    public GetOrderStatusUseCase(ProductionGateway productionGateway) {
        this.productionGateway = productionGateway;
    }

    public Optional<OrderState> execute(String orderId) {
        return productionGateway.getOrderState(orderId);
    }
}
