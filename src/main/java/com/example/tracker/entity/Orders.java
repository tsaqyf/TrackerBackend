package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer id;

    @Column(name = "po_number",nullable = true, length = 10)
    private char poNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_stage",nullable = true, length = 20)
    private OrdersEnum currentStage;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;
}
