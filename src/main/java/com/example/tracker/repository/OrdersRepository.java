package com.example.tracker.repository;

import com.example.tracker.entity.Client;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findByPoNumber(char poNumber);

    List<Orders> findByCurrentStage(OrdersEnum currentStage);

    List<Orders> findByClientId(Client clientId);

}
