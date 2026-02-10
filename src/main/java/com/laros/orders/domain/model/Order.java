package com.laros.orders.domain.model;

import java.time.LocalDateTime;

public class Order {

    private final OrderId id;
    private final String description;
    private final LocalDateTime createdAt;

    public Order(OrderId id, String description) {
        this.id = id;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public OrderId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
