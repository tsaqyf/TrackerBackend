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
public class Stations {

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

    @Column(nullable = false, length = 20)
    private String code;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "stationsid")
    private Set<Productionrouteplan> stationsidProductionrouteplans = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Productionrouteplan> getStationsidProductionrouteplans() {
        return stationsidProductionrouteplans;
    }

    public void setStationsidProductionrouteplans(
            final Set<Productionrouteplan> stationsidProductionrouteplans) {
        this.stationsidProductionrouteplans = stationsidProductionrouteplans;
    }

}
