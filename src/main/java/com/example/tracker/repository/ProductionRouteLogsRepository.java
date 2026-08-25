package com.example.tracker.repository;

import com.example.tracker.entity.ProductionRouteLogs;
import com.example.tracker.entity.ProductionRoutePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductionRouteLogsRepository extends JpaRepository<ProductionRouteLogs, UUID> {
    List<ProductionRouteLogs> findByStatus(String status);

    List<ProductionRouteLogs> findByProductionRoutePlanId(ProductionRoutePlan productionRoutePlanId);

}
