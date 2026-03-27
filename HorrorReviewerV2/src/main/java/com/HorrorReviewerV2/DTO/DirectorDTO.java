package com.HorrorReviewerV2.DTO;

import java.util.List;

public record DirectorDTO(
        Integer id,
        String name,
        List<MovieDTO> movieList
) {
}
