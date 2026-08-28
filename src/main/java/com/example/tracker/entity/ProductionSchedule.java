package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.UUID;

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
    private UUID id;

    @Column(name = "time_start", nullable = false)
    private Time timeStart;

    @Column(name = "time_finish", nullable = false)
    private Time timeFinish;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders ordersId;
}
