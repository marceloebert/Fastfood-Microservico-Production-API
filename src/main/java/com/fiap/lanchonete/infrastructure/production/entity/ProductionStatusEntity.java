package com.fiap.lanchonete.infrastructure.production.entity;

import java.io.Serializable;

public class ProductionStatusEntity implements Serializable {
    private String orderId;
    private String state;

    public ProductionStatusEntity() {}

    public ProductionStatusEntity(String orderId, String state) {
        this.orderId = orderId;
        this.state = state;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getState() {
        return state;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setState(String state) {
        this.state = state;
    }
}
