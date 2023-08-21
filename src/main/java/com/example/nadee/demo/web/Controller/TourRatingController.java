package com.example.nadee.demo.web.Controller;

import com.example.nadee.demo.repository.TourRatingRepository;
import com.example.nadee.demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tour rating controller
 * Spring MVC =>
 *   client request -> My RestController class -> My Service
 * Spring Data REST =>
 *   client request -> Spring Data REST -> My spring Data Repository
 */
@RestController
@RequestMapping(path = "/tours/{tourId}/ratings") // based url mapping
public class TourRatingController {

    TourRatingRepository tourRatingRepository;

    TourRepository tourRepository;

    public TourRatingController() {
    }

    @Autowired
    public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }
}
