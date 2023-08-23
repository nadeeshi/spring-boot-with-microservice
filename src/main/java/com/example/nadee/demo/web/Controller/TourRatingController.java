package com.example.nadee.demo.web.Controller;

import com.example.nadee.demo.domain.Tour;
import com.example.nadee.demo.domain.TourRating;
import com.example.nadee.demo.domain.TourRatingPk;
import com.example.nadee.demo.repository.TourRatingRepository;
import com.example.nadee.demo.repository.TourRepository;
import com.example.nadee.demo.web.DTO.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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

    /**
     * Create a Tour Rating
     * @Validated - This will validate our RayingDTO with required validation before pass next
     *
     * ValidateTourId - if this not exist it will return HTTP 404 - Not Found status
     *                  if it's passed and TourRating exist, and return HTTP 201 - CREATED status
     * @param tourId
     * @param ratingDTO - Rating data transfer object
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") int tourId,
                                 @RequestBody @Validated RatingDTO ratingDTO,
                                 BindingResult result) {

        if (result.hasErrors()) {
            //Handle validation errors
            // Return a response indicating validation failures
            System.out.println("Has validation errors" + result);
        }

        Tour tour = verifyTour(tourId);

        tourRatingRepository.save(new TourRating(new TourRatingPk(tour, ratingDTO.getCustomerId()),
                ratingDTO.getScore(), ratingDTO.getComment()));
    }

    /**
     * Verify and return the Tour given a tour id
     * @param tourId
     * @return the founded Tour
     * @throws NoSuchElementException if no Tour found
     */
    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId).orElseThrow(() ->
                new NoSuchElementException("Tour does not exist " + tourId));
    }

    /**
     * Exception handler if NoSuchElementException is thrown in this controller
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException exception) {
        return exception.getMessage();
    }
}
