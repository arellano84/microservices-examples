package com.laros.orders.domain.service;

import com.laros.orders.domain.model.Order;
import com.laros.orders.domain.model.OrderId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDomainServiceTest {

    private final OrderDomainService domainService = new OrderDomainService();

    @Test
    void should_throw_exception_when_description_is_empty() {
        Order order = new Order(new OrderId(), "");

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> domainService.validate(order));

        assertEquals("La descripción del pedido es obligatoria", exception.getMessage());
    }

    @Test
    void should_pass_validation_when_description_is_valid() {
        Order order = new Order(new OrderId(), "Pedido válido");

        assertDoesNotThrow(() -> domainService.validate(order));
    }
}