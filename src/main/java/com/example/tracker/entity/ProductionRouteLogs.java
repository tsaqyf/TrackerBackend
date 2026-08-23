package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "production_route_logs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionRouteLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "finish_time",nullable = false)
    private Time finishTime;

    @ManyToOne
    @JoinColumn(name = "production_route_plan_id")
    private ProductionRoutePlan productionRoutePlanId;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users usersId;
}
