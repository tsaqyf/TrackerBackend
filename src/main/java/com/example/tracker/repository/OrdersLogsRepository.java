package com.example.tracker.repository;

import com.example.tracker.entity.OrdersLogs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrdersLogsRepository extends JpaRepository<OrdersLogs, UUID> {
    List<OrdersLogs> findByPoNumbers(String poNumbers);

}
