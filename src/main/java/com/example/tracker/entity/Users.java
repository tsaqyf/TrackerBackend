package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "name",nullable = false, length = 20)
    private String name;

    @Column(name = "password",nullable = false, length = 100)
    private String password;

    @Column(name = "division",nullable = false, length = 20)
    private String division;

    @ManyToOne
    @JoinColumn(name = "stations_id")
    private Stations stationId;
}
