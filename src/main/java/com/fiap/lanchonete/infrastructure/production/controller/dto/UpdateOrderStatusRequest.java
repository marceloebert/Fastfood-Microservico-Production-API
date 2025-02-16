package com.fiap.lanchonete.infrastructure.production.controller.dto;

public class UpdateOrderStatusRequest {

    private String state;

    public UpdateOrderStatusRequest() {
    }

    public UpdateOrderStatusRequest(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
