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
public class Orders {

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

    @Column(nullable = false, length = 10)
    private String ponumber;

    @Column(nullable = false, length = 20)
    private String currentstage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid_id")
    private Client clientid;

    @OneToMany(mappedBy = "ordersid")
    private Set<Orderstagelogs> ordersidOrderstagelogses = new HashSet<>();

    @OneToMany(mappedBy = "ordersid")
    private Set<Productionschedule> ordersidProductionschedules = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPonumber() {
        return ponumber;
    }

    public void setPonumber(final String ponumber) {
        this.ponumber = ponumber;
    }

    public String getCurrentstage() {
        return currentstage;
    }

    public void setCurrentstage(final String currentstage) {
        this.currentstage = currentstage;
    }

    public Client getClientid() {
        return clientid;
    }

    public void setClientid(final Client clientid) {
        this.clientid = clientid;
    }

    public Set<Orderstagelogs> getOrdersidOrderstagelogses() {
        return ordersidOrderstagelogses;
    }

    public void setOrdersidOrderstagelogses(final Set<Orderstagelogs> ordersidOrderstagelogses) {
        this.ordersidOrderstagelogses = ordersidOrderstagelogses;
    }

    public Set<Productionschedule> getOrdersidProductionschedules() {
        return ordersidProductionschedules;
    }

    public void setOrdersidProductionschedules(
            final Set<Productionschedule> ordersidProductionschedules) {
        this.ordersidProductionschedules = ordersidProductionschedules;
    }

}
