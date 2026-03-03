package com.SpringBoot_basic.Springboot_basic.Controllers;

import com.SpringBoot_basic.Springboot_basic.Entities.Movie;
import com.SpringBoot_basic.Springboot_basic.Repositories.MovieRepository;
import com.SpringBoot_basic.Springboot_basic.Services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/movies")
    public ResponseEntity<?> getAllMovies(){
        try{
            List<Movie> movieList=movieService.getAllMovies();
            return ResponseEntity.ok(movieList);

        }catch (Exception e){
            return ResponseEntity.status(500).body("SERVER ERROR: Database Error.\n\n\n\n\n"+e.getMessage());
        }
        }
    @GetMapping("/api/movies/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable Integer movieId){

            Movie foundMovie=movieService.getMovieById(movieId);
            if(foundMovie!=null){
                return ResponseEntity.ok(foundMovie);
            }else{
                return ResponseEntity.status(404).body("Pelicula no encontrada");
            }

        }

    @GetMapping("/api/movies/title/{movieTitle}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable String movieTitle){
        Movie foundMovie=movieService.getMovieByTitle(movieTitle);
        if(foundMovie!=null){
            return ResponseEntity.ok(foundMovie);
        }else {
            return  ResponseEntity.status(404).body("pelicula no encontrada");
        }
    }
}
