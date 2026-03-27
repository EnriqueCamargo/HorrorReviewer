package com.HorrorReviewerV2.Repositories;

import com.HorrorReviewerV2.Entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
    public Director existsByName(String name);
}
