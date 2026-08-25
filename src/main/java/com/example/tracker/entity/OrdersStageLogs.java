package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "orders_stage_logs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersStageLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "start_time", nullable = false, length = 7)
    private Time startTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "stage",nullable = false, length = 20)
    private OrdersEnum stage;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders ordersId;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users userId;
}
