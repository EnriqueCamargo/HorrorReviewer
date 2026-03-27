package com.HorrorReviewerV2.DTO;

import com.HorrorReviewerV2.Enums.Role;

import java.util.List;

public record UserDTO(
        Integer id,
        String username,
        String email,
        String password,
        Role role,
        List<ReviewDTO> reviews
) {
}
