package com.example.tracker.repository;

import com.example.tracker.entity.ProductionRoutePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionRoutePlanRepository extends JpaRepository<ProductionRoutePlan, Integer> {
    List<ProductionRoutePlan> findBySequenceNo(int sequenceNo);

}
