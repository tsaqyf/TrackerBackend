package com.example.tracker.repository;

import com.example.tracker.dto.ActiveStepViewResponse;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersRoute;
import com.example.tracker.entity.OrdersStepEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersRouteRepository extends JpaRepository<OrdersRoute, UUID> {
    Optional<OrdersRoute> findByOrdersIdAndId(Orders ordersId, UUID id);

    Optional<OrdersRoute> findFirstByOrdersIdAndStepLabelNotOrderBySequenceAsc(Orders ordersId, OrdersStepEnum stepLabel);

    List<OrdersRoute> findByOrdersIdAndStepLabelNot(Orders ordersId, OrdersStepEnum stepLabel);

    List<OrdersRoute> findByOrdersIdOrderBySequenceAsc(Orders ordersId);

    @Query("""
        SELECT new com.example.tracker.dto.ActiveStepViewResponse(
            r.orders.id, r.orders.poNumber, r.orders.clientName,
            r.id, r.routeLabel, r.sequence, r.stepLabel)
        FROM OrdersRoute r
        WHERE r.stationCode = :stationCode
        AND r.stepLabel NOT IN ('DONE', 'CANCELLED')
        AND r.sequence= (
            SELECT MIN(r2.sequence) FROM OrderRoute r2
            WHERE r2.order.id = r.order.id
            AND r2.stepLabel NOT IN ('DONE', 'CANCELLED')
        )
        ORDER BY r.orders.createdAt ASC
        """)
    List<ActiveStepViewResponse> findActiveStepsByStation(@Param("stationCode") String stationCode);
}
