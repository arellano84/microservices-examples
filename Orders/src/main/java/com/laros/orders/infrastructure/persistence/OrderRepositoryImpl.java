package com.laros.orders.infrastructure.persistence;

import com.laros.orders.domain.model.Order;
import com.laros.orders.domain.repository.OrderRepository;
import com.laros.orders.infrastructure.persistence.jpa.OrderJpaEntity;
import com.laros.orders.infrastructure.persistence.jpa.SpringDataOrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final SpringDataOrderRepository jpaRepository;

    public OrderRepositoryImpl(SpringDataOrderRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Order order) {
        OrderJpaEntity entity = new OrderJpaEntity(
                order.getId().getValue(),
                order.getDescription(),
                order.getCreatedAt()
        );

        jpaRepository.save(entity);
    }
}
