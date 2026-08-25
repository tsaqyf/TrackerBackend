package com.example.tracker.repository;

import com.example.tracker.entity.ProductionRoutePlan;
import com.example.tracker.entity.ProductionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductionRoutePlanRepository extends JpaRepository<ProductionRoutePlan, UUID> {
    List<ProductionRoutePlan> findBySequenceNo(int sequenceNo);

    List<ProductionRoutePlan> findByCurrentStatusAndProductionScheduleId(String currentStatus, ProductionSchedule productionScheduleId);


}
