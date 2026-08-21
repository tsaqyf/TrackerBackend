package com.example.tracker.entitys.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Orderstagelogs {

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
    private String stage;

    @Column(nullable = false, length = 20)
    private String createdby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordersid_id")
    private Orders ordersid;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(final String stage) {
        this.stage = stage;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(final String createdby) {
        this.createdby = createdby;
    }

    public Orders getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(final Orders ordersid) {
        this.ordersid = ordersid;
    }

}
