package com.laros.orders.infrastructure.controller;

import com.laros.orders.application.command.CreateOrderCommand;
import com.laros.orders.application.service.OrderApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderApplicationService service;

    public OrderController(OrderApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderCommand command) {
        String orderId = service.createOrder(command);
        return ResponseEntity.ok(orderId);
    }
}
