package com.example.tracker.repository;

import com.example.tracker.entity.OrdersRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRouteRepository extends JpaRepository<OrdersRoute, UUID> {

}
