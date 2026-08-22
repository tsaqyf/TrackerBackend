package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ordersstagelogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersStageLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
