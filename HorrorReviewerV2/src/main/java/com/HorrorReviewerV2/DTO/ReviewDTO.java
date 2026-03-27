package com.HorrorReviewerV2.DTO;

import com.HorrorReviewerV2.Entities.Movie;
import com.HorrorReviewerV2.Entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReviewDTO(
        Integer id,
        BigDecimal rating,
        String comment,
        LocalDateTime createdAt,
        Integer movieId,
        String movieTitle,
        Integer userId,
        String username
) {
}
