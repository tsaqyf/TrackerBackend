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
public class Productionroutelogs {

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
    private Integer id;

    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productionrouteplanid_id")
    private Productionrouteplan productionrouteplanid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid_id")
    private Users userid;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Productionrouteplan getProductionrouteplanid() {
        return productionrouteplanid;
    }

    public void setProductionrouteplanid(final Productionrouteplan productionrouteplanid) {
        this.productionrouteplanid = productionrouteplanid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(final Users userid) {
        this.userid = userid;
    }

}
