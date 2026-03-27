package com.HorrorReviewerV2.Repositories;

import com.HorrorReviewerV2.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    Boolean existsByUsernameContainingIgnoreCase(String username);
}
