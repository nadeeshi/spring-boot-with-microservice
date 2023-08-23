package com.example.nadee.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

/**
 * JPA entity
 */
@Embeddable
public class TourRatingPk implements Serializable {

    @ManyToOne
    private Tour tour;


    @Column(insertable = false, updatable = false, nullable = false)
    private Integer customerId;

    public TourRatingPk() {
    }

    public TourRatingPk(Tour tour, Integer customerId) {
        this.tour = tour;
        this.customerId = customerId;
    }

    public Tour getTour() {
        return tour;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}
