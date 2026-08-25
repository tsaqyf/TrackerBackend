package com.example.tracker.repository;

import com.example.tracker.entity.OrdersEnum;
import com.example.tracker.entity.OrdersStageLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrdersStageLogsRepository extends JpaRepository<OrdersStageLogs, UUID> {
    List<OrdersStageLogs> findByStage(OrdersEnum stage);

}
