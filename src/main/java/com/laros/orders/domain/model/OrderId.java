package com.laros.orders.domain.model;

import java.util.UUID;

public class OrderId {

    private final String value;

    public OrderId() {
        this.value = UUID.randomUUID().toString();
    }

    public String getValue() {
        return value;
    }
}
