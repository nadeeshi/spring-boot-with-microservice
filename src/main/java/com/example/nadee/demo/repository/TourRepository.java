package com.example.nadee.demo.repository;

import com.example.nadee.demo.domain.Tour;
import org.springframework.data.repository.CrudRepository;

/**
 * TourRepository interface
 * Tour - domain type
 * Integer - ID type (ID of the entity)
 */
public interface TourRepository extends CrudRepository<Tour, Integer> {
}
