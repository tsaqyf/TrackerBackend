package com.example.tracker.repository;

import com.example.tracker.entity.Client;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersPhaseEnum;
import com.example.tracker.entity.Stations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {

}
