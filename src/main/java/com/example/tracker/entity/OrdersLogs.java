package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "orders_stage_logs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "po_numbers")
    private String poNumbers;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "is_active", nullable = false)
    private Timestamp isActive;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders ordersId;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users userId;

    @OneToOne
    @JoinColumn(name = "stations_id")
    private Stations stationsId;

    @OneToOne
    @JoinColumn(name = "orders_route_id")
    private OrdersRoute ordersRouteId;
}
