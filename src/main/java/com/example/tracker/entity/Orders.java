package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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

    @Column(name = "client_name",length = 10, nullable = false)
    private String clientName;

    @Column(name = "client_company",length = 20, nullable = false)
    private String clientCompany;

    @Column(name = "is_active", nullable = false)
    private Timestamp isActive;

    @OneToMany(mappedBy = "ordersId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sequence ASC")
    private List<OrdersRoute> routesStep = new ArrayList<>();

}
