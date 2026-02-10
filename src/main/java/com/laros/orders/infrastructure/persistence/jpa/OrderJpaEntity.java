package com.laros.orders.infrastructure.persistence.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderJpaEntity {

    @Id
    @Column(length = 36)
    private String id;

    private String description;

    private LocalDateTime createdAt;

    protected OrderJpaEntity() {
        // JPA
    }

    public OrderJpaEntity(String id, String description, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
