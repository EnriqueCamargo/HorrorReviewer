package com.HorrorReviewerV2.Repositories;

import com.HorrorReviewerV2.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
