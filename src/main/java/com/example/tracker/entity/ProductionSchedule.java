package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "production_schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "planned_start", nullable = false)
    private Time plannedStart;

    @Column(name = "planned_end", nullable = false)
    private Time plannedEnd;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders ordersId;
}
