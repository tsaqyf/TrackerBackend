package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer id;

    @Column(name = "name",nullable = true, length = 20)
    private String name;

    @Column(name = "password",nullable = true, length = 10)
    private char password;

    @Column(name = "division",nullable = true, length = 20)
    private String division;

    @ManyToOne
    @JoinColumn(name = "stations_id")
    private Stations station_id;
}
