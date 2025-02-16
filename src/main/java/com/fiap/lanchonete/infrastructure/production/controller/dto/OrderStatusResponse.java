package com.fiap.lanchonete.infrastructure.production.controller.dto;

public class OrderStatusResponse {
    private String orderId;
    private String state;

    public OrderStatusResponse(String orderId, String state) {
        this.orderId = orderId;
        this.state = state;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getState() {
        return state;
    }
}
