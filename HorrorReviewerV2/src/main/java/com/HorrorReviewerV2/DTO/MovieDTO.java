package com.HorrorReviewerV2.DTO;

import com.HorrorReviewerV2.Entities.Review;
import com.HorrorReviewerV2.Enums.Genre;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.List;

public record MovieDTO(
        Integer id,
        String title,
        Integer length,
        Genre genre,
        LocalDate releaseDate,
        boolean available,
        Integer directorId,
        String directorName,
        List<ReviewDTO> reviews

        ) {
}
