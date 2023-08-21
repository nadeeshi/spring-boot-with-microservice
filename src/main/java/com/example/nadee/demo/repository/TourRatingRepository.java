package com.example.nadee.demo.repository;

import com.example.nadee.demo.domain.TourRating;
import com.example.nadee.demo.domain.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data Repository
 */
@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

    /**
     * Lookup all the TourRatings for a tour
     * @param tourId
     * @return
     */
    List<TourRating> findByPkTourId(Integer tourId);


    /**
     * Lookup a TourRating by the tourId and CustomerId
     * @param tourId
     * @param customerId
     * @return
     */
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
