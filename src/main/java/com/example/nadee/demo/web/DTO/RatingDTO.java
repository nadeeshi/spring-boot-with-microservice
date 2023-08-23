package com.example.nadee.demo.web.DTO;

import com.example.nadee.demo.domain.TourRating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

/**
 * Data Transfer Object for Rating a Tour
 */
@Validated
public class RatingDTO {

    // @Range(min = 0, max = 5)
    @Min(value = 0) // These annotations work correctly with Long values, but there can be issues with Integer values due to their range and representation
    @Max(value = 5)
    private Integer score;

    @Size(max = 255) // Validating the size of collections, arrays, or strings
    private String comment;

    @NotNull
    private Integer customerId;

    public RatingDTO(TourRating tourRating) {
        this(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }

    public RatingDTO() {
    }

    public RatingDTO(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
