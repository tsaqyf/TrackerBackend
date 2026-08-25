package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "production_route_plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionRoutePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "sequence_no", nullable = false)
    private int sequenceNo;

    @Column(name = "current_status",nullable = false)
    private String currentStatus;

    @ManyToOne
    @JoinColumn(name = "production_schedule_id")
    private ProductionSchedule productionScheduleId;

    @ManyToOne
    @JoinColumn(name = "stations_id")
    private Stations stationsId;
}
