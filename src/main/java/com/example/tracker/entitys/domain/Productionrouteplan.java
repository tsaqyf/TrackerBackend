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
import java.util.HashSet;
import java.util.Set;


@Entity
public class Productionrouteplan {

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
    private Integer sequenceno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productionscheduleid_id")
    private Productionschedule productionscheduleid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stationsid_id")
    private Stations stationsid;

    @OneToMany(mappedBy = "productionrouteplanid")
    private Set<Productionroutelogs> productionrouteplanidProductionroutelogses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(final Integer sequenceno) {
        this.sequenceno = sequenceno;
    }

    public Productionschedule getProductionscheduleid() {
        return productionscheduleid;
    }

    public void setProductionscheduleid(final Productionschedule productionscheduleid) {
        this.productionscheduleid = productionscheduleid;
    }

    public Stations getStationsid() {
        return stationsid;
    }

    public void setStationsid(final Stations stationsid) {
        this.stationsid = stationsid;
    }

    public Set<Productionroutelogs> getProductionrouteplanidProductionroutelogses() {
        return productionrouteplanidProductionroutelogses;
    }

    public void setProductionrouteplanidProductionroutelogses(
            final Set<Productionroutelogs> productionrouteplanidProductionroutelogses) {
        this.productionrouteplanidProductionroutelogses = productionrouteplanidProductionroutelogses;
    }

}
