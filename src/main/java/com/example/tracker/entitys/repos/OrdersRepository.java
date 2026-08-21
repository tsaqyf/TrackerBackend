package com.example.tracker.entitys.repos;

import com.example.tracker.entitys.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
