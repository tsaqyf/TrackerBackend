package com.example.tracker.repository;

import com.example.tracker.entity.ProductionRouteLogs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionRouteLogsRepository extends JpaRepository<ProductionRouteLogs,Integer> {
    List<ProductionRouteLogs> findByStatus(String status);

}
