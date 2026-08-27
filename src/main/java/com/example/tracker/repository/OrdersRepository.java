package com.example.tracker.repository;

import com.example.tracker.entity.Client;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersEnum;
import com.example.tracker.entity.Stations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {
    Optional<Orders> findByPoNumber(String poNumber);

    List<Orders> findByCurrentStage(OrdersEnum currentStage);

    List<Orders> findByClientId(Client clientId);

    Optional<Orders> findByStationsId_Code(String code);

    boolean existsByStationsId_Code(String code);

}
