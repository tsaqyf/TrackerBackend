package com.example.tracker.entitys.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Client {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private Integer name;

    @Column(nullable = false, length = 20)
    private String companny;

    @OneToMany(mappedBy = "clientid")
    private Set<Orders> clientidOrderses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(final Integer name) {
        this.name = name;
    }

    public String getCompanny() {
        return companny;
    }

    public void setCompanny(final String companny) {
        this.companny = companny;
    }

    public Set<Orders> getClientidOrderses() {
        return clientidOrderses;
    }

    public void setClientidOrderses(final Set<Orders> clientidOrderses) {
        this.clientidOrderses = clientidOrderses;
    }

}
