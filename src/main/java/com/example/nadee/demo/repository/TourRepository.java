package com.example.nadee.demo.repository;

import com.example.nadee.demo.domain.Tour;
import com.example.nadee.demo.types.Difficulty;
import com.example.nadee.demo.types.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * TourRepository interface
 * Tour - domain type
 * Integer - ID type (ID of the entity)
 */
public interface TourRepository extends CrudRepository<Tour, Integer> {

    List<Tour> findByTourPackageCode(String code);

    /**
     * Return one Tour, because title is unique
     */
    Optional<Tour> findByTitle(String title);

    List<Tour> findByPrice(Integer price);

    /**
     * Invalid - throws IncorrectResultSizeDataAccessException
     * @param difficulty
     * @return
     */
    Collection<Tour> findByDifficulty(Difficulty difficulty);

    List<Tour> findByRegion(Region region);

    List<Tour> findByTourPackageCodeAndRegion(String code, Region region);

    List<Tour> findByRegionIn(List<Region> regions);
}
