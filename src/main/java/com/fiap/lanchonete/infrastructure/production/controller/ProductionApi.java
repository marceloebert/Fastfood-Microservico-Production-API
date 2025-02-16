package com.fiap.lanchonete.infrastructure.production.controller;

import com.fiap.lanchonete.application.production.usecases.GetOrderStatusUseCase;
import com.fiap.lanchonete.application.production.usecases.UpdateOrderStatusUseCase;
import com.fiap.lanchonete.application.production.usecases.CreateOrderStatusUseCase;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import com.fiap.lanchonete.infrastructure.production.controller.dto.UpdateOrderStatusRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/production")
public class ProductionApi {

    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final GetOrderStatusUseCase getOrderStatusUseCase;
    private final CreateOrderStatusUseCase createOrderStatusUseCase;


    public ProductionApi(UpdateOrderStatusUseCase updateOrderStatusUseCase, GetOrderStatusUseCase getOrderStatusUseCase, CreateOrderStatusUseCase createOrderStatusUseCase) {
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
        this.getOrderStatusUseCase = getOrderStatusUseCase;
        this.createOrderStatusUseCase = createOrderStatusUseCase;
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable String orderId, @RequestBody UpdateOrderStatusRequest request) {
        updateOrderStatusUseCase.execute(orderId, OrderState.valueOf(request.getState()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}/status")
    public ResponseEntity<OrderState> getOrderStatus(@PathVariable String orderId) {
        Optional<OrderState> status = getOrderStatusUseCase.execute(orderId);
        return status.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{orderId}")
    public ResponseEntity<String> createOrderStatus(@PathVariable String orderId) {
        createOrderStatusUseCase.execute(orderId, OrderState.PENDING);
        return ResponseEntity.ok("Status de produção criado com sucesso!");
    }
}
