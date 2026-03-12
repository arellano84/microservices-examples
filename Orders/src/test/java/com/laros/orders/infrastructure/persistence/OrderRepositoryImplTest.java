package com.laros.orders.infrastructure.persistence;

import com.laros.orders.domain.model.Order;
import com.laros.orders.domain.model.OrderId;
import com.laros.orders.infrastructure.persistence.jpa.SpringDataOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(OrderRepositoryImpl.class)
class OrderRepositoryImplTest {

    @Autowired
    private OrderRepositoryImpl repository;

    @Autowired
    private SpringDataOrderRepository jpaRepository;

    @Test
    void should_save_order_using_jpa() {
        Order order = new Order(new OrderId(), "Pedido con JPA");

        repository.save(order);

        assertThat(jpaRepository.findById(order.getId().getValue()))
                .isPresent();
    }
}