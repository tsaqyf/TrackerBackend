package com.example.tracker.repository;

import com.example.tracker.dto.ActiveStepViewResponse;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersRoute;
import com.example.tracker.entity.OrdersStepEnum;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersRouteRepository extends JpaRepository<OrdersRoute, UUID> {
    Optional<OrdersRoute> findFirstByOrdersId_IdAndStepLabelNotOrderBySequenceAsc(UUID id, OrdersStepEnum stepLabel);

    Optional<OrdersRoute> findByOrdersId_IdAndId(UUID id, UUID id1);

    List<OrdersRoute> findByOrdersIdAndStepLabelNot(Orders ordersId, OrdersStepEnum stepLabel);

    List<OrdersRoute> findByOrdersIdOrderBySequenceAsc(Orders ordersId);

    @Query("""
        SELECT new com.example.tracker.dto.ActiveStepViewResponse(
            r.orders.id, r.orders.poNumber, r.orders.clientName,
            r.id, r.routeLabel, r.sequence, r.stepLabel)
        FROM OrdersRoute r
        WHERE r.stationCode = :stationCode
        AND r.stepLabel = 'IN_PROGRESS'
        ORDER BY r.orders.createdAt ASC
        """)
    List<ActiveStepViewResponse> findActiveStepsByStation(@Param("stationCode") String stationCode);
}
