package com.example.nadee.demo.service;

import com.example.nadee.demo.domain.Tour;
import com.example.nadee.demo.domain.TourPackage;
import com.example.nadee.demo.repository.TourPackageRepository;
import com.example.nadee.demo.repository.TourRepository;
import com.example.nadee.demo.types.Difficulty;
import com.example.nadee.demo.types.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private TourRepository tourRepository;

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour Object and save it in the db
     *
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageName
     * @param difficulty
     * @param region
     * @return
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets, String keywords, String tourPackageName,
                           Difficulty difficulty, Region region) {

        TourPackage tourPackage = tourPackageRepository.findById(tourPackageName)
                .orElseThrow(() ->
                        new RuntimeException("Tour package does not exist: " + tourPackageName));

        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }


    /**
     * Calculate the number of Tours in the db
     *
     * @return
     */
    public long total() {
        return tourRepository.count();
    }
}
