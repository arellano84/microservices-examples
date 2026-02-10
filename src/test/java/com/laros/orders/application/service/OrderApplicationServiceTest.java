package com.laros.orders.application.service;

import com.laros.orders.application.command.CreateOrderCommand;
import com.laros.orders.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderApplicationServiceTest {

    private OrderRepository repository;
    private OrderApplicationService service;

    @BeforeEach
    void setup() {
        repository = mock(OrderRepository.class);
        service = new OrderApplicationService(repository);
    }

    @Test
    void should_create_order_and_save_it() {
        CreateOrderCommand command = new CreateOrderCommand("Pedido de prueba");

        String orderId = service.createOrder(command);

        assertNotNull(orderId);
        verify(repository, times(1)).save(any());
    }

    @Test
    void should_fail_when_description_is_null() {
        CreateOrderCommand command = new CreateOrderCommand(null);

        assertThrows(IllegalArgumentException.class,
                () -> service.createOrder(command));

        verify(repository, never()).save(any());
    }
}