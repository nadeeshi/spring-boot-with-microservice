package com.example.nadee.demo.repository;

import com.example.nadee.demo.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    /**
     * Spring query method - Find Tour Package by name
     * @param name - name of the package
     * @return optional of TourPackage
     */
    Optional<TourPackage> findByName(String name);
}
