package com.SpringBoot_basic.Springboot_basic.Services;

import com.SpringBoot_basic.Springboot_basic.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;
}
