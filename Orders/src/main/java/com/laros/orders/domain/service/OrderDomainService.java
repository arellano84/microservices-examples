package com.laros.orders.domain.service;

import com.laros.orders.domain.model.Order;

public class OrderDomainService {

    public void validate(Order order) {
        if (order.getDescription() == null || order.getDescription().isEmpty()) {
            throw new IllegalArgumentException("La descripción del pedido es obligatoria");
        }
    }
}
