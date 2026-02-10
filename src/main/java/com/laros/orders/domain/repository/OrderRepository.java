package com.laros.orders.domain.repository;

import com.laros.orders.domain.model.Order;

public interface OrderRepository {

    void save(Order order);
}
