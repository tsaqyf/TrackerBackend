package com.example.tracker.repository;

import com.example.tracker.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {

}
