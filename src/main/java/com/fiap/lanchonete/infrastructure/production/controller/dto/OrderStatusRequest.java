package com.fiap.lanchonete.infrastructure.production.controller.dto;

public class OrderStatusRequest {
    private String state;

    public OrderStatusRequest() {}

    public OrderStatusRequest(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
