package com.HorrorReviewerV2.Controllers;

import com.HorrorReviewerV2.Entities.Movie;
import com.HorrorReviewerV2.Services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/api/movies/post")
    public ResponseEntity<?> postNewMovie(@RequestBody Movie movie){
        try{
            Movie savedMovie=movieService.postMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/api/movies/{id}")
    public ResponseEntity<?> putMovieById(@PathVariable Integer id, @RequestBody Movie updatedmovie){

        try {
            Movie result= movieService.putMovieById(id, updatedmovie);
            if(result!=null){
                return ResponseEntity.ok(result);
            }else {
                return ResponseEntity.status(404).body("pelicula con Id "+id+" no encontrada");
            }
        }catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id){
        try{
            movieService.deleteMoviebyId(id);
        }catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok().body("Pelicula eliminada Correctamente");
    }
}
