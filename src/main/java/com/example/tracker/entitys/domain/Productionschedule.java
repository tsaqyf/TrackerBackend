package com.example.tracker.entitys.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Productionschedule {

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
    private LocalTime plannedstart;

    @Column(nullable = false)
    private LocalTime plannedend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordersid_id", nullable = false)
    private Orders ordersid;

    @OneToMany(mappedBy = "productionscheduleid")
    private Set<Productionrouteplan> productionscheduleidProductionrouteplans = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalTime getPlannedstart() {
        return plannedstart;
    }

    public void setPlannedstart(final LocalTime plannedstart) {
        this.plannedstart = plannedstart;
    }

    public LocalTime getPlannedend() {
        return plannedend;
    }

    public void setPlannedend(final LocalTime plannedend) {
        this.plannedend = plannedend;
    }

    public Orders getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(final Orders ordersid) {
        this.ordersid = ordersid;
    }

    public Set<Productionrouteplan> getProductionscheduleidProductionrouteplans() {
        return productionscheduleidProductionrouteplans;
    }

    public void setProductionscheduleidProductionrouteplans(
            final Set<Productionrouteplan> productionscheduleidProductionrouteplans) {
        this.productionscheduleidProductionrouteplans = productionscheduleidProductionrouteplans;
    }

}
