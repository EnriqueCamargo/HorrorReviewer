package com.SpringBoot_basic.Springboot_basic.Repositories;

import com.SpringBoot_basic.Springboot_basic.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
