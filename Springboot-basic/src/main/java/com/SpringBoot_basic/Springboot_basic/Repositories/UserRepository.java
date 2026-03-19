package com.SpringBoot_basic.Springboot_basic.Repositories;

import com.SpringBoot_basic.Springboot_basic.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    Boolean existsByUsernameContainingIgnoreCase(String username);
}
