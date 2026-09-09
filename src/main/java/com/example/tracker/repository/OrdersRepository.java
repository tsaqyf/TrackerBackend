package com.example.tracker.repository;

import com.example.tracker.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {
    Optional<Orders> findByPoNumber(String poNumber);

    @Override
    Optional<Orders> findById(UUID uuid);
}
