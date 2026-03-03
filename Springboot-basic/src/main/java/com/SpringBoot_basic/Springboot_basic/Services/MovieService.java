package com.SpringBoot_basic.Springboot_basic.Services;

import com.SpringBoot_basic.Springboot_basic.Entities.Movie;
import com.SpringBoot_basic.Springboot_basic.Repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MovieService {
private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer movieId){
        return movieRepository.findById(movieId).orElse(null);
    }
    public Movie getMovieByTitle(String movieTitle){
        List<Movie>movieList= movieRepository.findAll();
        return movieList.stream().filter(m -> m.getTitle().equalsIgnoreCase(movieTitle)).findFirst().orElse(null);
    }
}
