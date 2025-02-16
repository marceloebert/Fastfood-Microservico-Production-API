package com.fiap.lanchonete.application.production.gateways;

import com.fiap.lanchonete.entities.orders.enums.OrderState;
import com.fiap.lanchonete.infrastructure.production.repository.ProductionStatusRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductionGatewayImpl implements ProductionGateway {

    private final ProductionStatusRepository productionStatusRepository;

    public ProductionGatewayImpl(ProductionStatusRepository productionStatusRepository) {
        this.productionStatusRepository = productionStatusRepository;
    }

    @Override
    public Optional<OrderState> getOrderState(String orderId) {
        return productionStatusRepository.getOrderState(orderId)
                .map(state -> OrderState.valueOf(state)); // ✅ Converte de String para OrderState
    }

    @Override
    public void updateOrderState(String orderId, OrderState state) {
        productionStatusRepository.updateOrderState(orderId, state.name()); // ✅ Salva como String
    }

    @Override
    public void createOrderState(String orderId, OrderState initialState) {
        productionStatusRepository.createOrderState(orderId, initialState.name());
    }

}
