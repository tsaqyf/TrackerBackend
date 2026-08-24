package com.example.tracker.repository;

import com.example.tracker.entity.Orders;
import com.example.tracker.entity.ProductionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductionScheduleRepository extends JpaRepository<ProductionSchedule, Integer> {

    @Override
    Optional<ProductionSchedule> findById(Integer integer);

    List<ProductionSchedule> findByOrdersId(Orders ordersId);

}
