package com.example.nadee.demo.repository;

import com.example.nadee.demo.domain.Tour;
import com.example.nadee.demo.types.Difficulty;
import com.example.nadee.demo.types.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * TourRepository interface
 * Tour - domain type
 * Integer - ID type (ID of the entity)
 */
public interface TourRepository extends CrudRepository<Tour, Integer> {
//public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {

    /**
     * Find Tours associated with the Tour Package
     * @param code - tour package code
     * @return list of tours
     */
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

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

  //  Tour save(Tour tour);

    long count();

    @Override
    @RestResource(exported = false)
    <T extends Tour> T save(T t);

    @Override
    @RestResource(exported = false)
    <T extends Tour> Iterable<T> saveAll(Iterable<T> iterable);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer id);

    @Override
    @RestResource(exported = false)
    void delete(Tour tour);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
