package com.laros.orders.infrastructure.persistence;

import com.laros.orders.domain.model.Order;
import com.laros.orders.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> database = new ArrayList<>();

    @Override
    public void save(Order order) {
        database.add(order);
    }
}
