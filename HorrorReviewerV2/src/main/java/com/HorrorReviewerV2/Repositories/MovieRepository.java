package com.HorrorReviewerV2.Repositories;

import com.HorrorReviewerV2.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Boolean existsByTitleContainingIgnoreCase(String title);
    List<Movie> findByDirectorId(Integer directorId);
    List<Movie> findByDirectorNameContainingIgnoreCase(String directorName);
}
