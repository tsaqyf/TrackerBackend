package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "orders_route")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "sequence")
    private int sequence;

    @Column(name = "route_label")
    private OrdersRouteEnum routeLabel;

    @Column(name = "step_label")
    private OrdersStepEnum stepLabel = OrdersStepEnum.PENDING;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "is_active")
    private Timestamp isActive;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders ordersId;

    @OneToOne
    @JoinColumn(name = "stations_id")
    private Stations stationsId;

    public OrdersRoute(int sequence, OrdersRouteEnum routeLabel, OrdersStepEnum stepLabel){
        this.sequence = sequence;
        this.routeLabel = routeLabel;
        this.stepLabel = stepLabel;
    }
}
