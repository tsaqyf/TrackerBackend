package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "po_number",nullable = false, length = 20)
    private String poNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_phase",nullable = false, length = 20)
    private OrdersPhaseEnum currentPhase;

    @Column(name = "is_active", nullable = false)
    private Timestamp isActive;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

}
