package com.example.nadee.demo.repository;

import com.example.nadee.demo.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

/**
 * @RespositoryRestResource - control access at the class level
 * @RestResource - control access at the method level
 */
@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    /**
     * Spring query method - Find Tour Package by name
     * @param name - name of the package
     * @return optional of TourPackage
     */
    Optional<TourPackage> findByName(@Param("name") String name);

    @Override
    @RestResource(exported = false) // Restrict access from outer world
    <T extends TourPackage> T save(T t);

    @Override
    @RestResource(exported = false)
    <T extends TourPackage> Iterable<T> saveAll(Iterable<T> iterable);

    @Override
    @RestResource(exported = false)
    void deleteById(String id);

    @Override
    @RestResource(exported = false)
    void delete(TourPackage tourPackage);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends TourPackage> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
