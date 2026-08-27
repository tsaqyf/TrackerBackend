package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "current_stage",nullable = false, length = 20)
    private OrdersEnum currentStage;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @OneToOne
    @JoinColumn(name = "stations_id")
    private Stations stationsId;

}
