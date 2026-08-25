package com.example.tracker.repository;

import com.example.tracker.entity.Orders;
import com.example.tracker.entity.ProductionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductionScheduleRepository extends JpaRepository<ProductionSchedule, UUID> {

    @Override
    Optional<ProductionSchedule> findById(UUID integer);

    List<ProductionSchedule> findByOrdersId(Orders ordersId);

}
