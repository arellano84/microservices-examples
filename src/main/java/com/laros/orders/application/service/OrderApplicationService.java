package com.laros.orders.application.service;

import com.laros.orders.application.command.CreateOrderCommand;
import com.laros.orders.domain.model.Order;
import com.laros.orders.domain.model.OrderId;
import com.laros.orders.domain.repository.OrderRepository;
import com.laros.orders.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;

@Service
public class OrderApplicationService {

    private final OrderRepository repository;
    private final OrderDomainService domainService = new OrderDomainService();

    public OrderApplicationService(OrderRepository repository) {
        this.repository = repository;
    }

    public String createOrder(CreateOrderCommand command) {
        Order order = new Order(new OrderId(), command.getDescription());
        domainService.validate(order);
        repository.save(order);
        return order.getId().getValue();
    }
}
