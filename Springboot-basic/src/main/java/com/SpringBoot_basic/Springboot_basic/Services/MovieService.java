package com.SpringBoot_basic.Springboot_basic.Services;

import com.SpringBoot_basic.Springboot_basic.Entities.Director;
import com.SpringBoot_basic.Springboot_basic.Entities.Movie;
import com.SpringBoot_basic.Springboot_basic.Repositories.DirectorRepository;
import com.SpringBoot_basic.Springboot_basic.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private MovieRepository movieRepository;

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

    public Movie postMovie(Movie movie) {

        if (movie.getDirector() == null || movie.getDirector().getId() == null) {
            throw new RuntimeException("Debe proporcionar un Director válido.");
        }

        Integer directorId = movie.getDirector().getId();

        if (!directorRepository.existsById(directorId)) {
            throw new RuntimeException("El director con ID " + directorId + " no existe.");
        }


        if (movieRepository.existsByTitleContainingIgnoreCase(movie.getTitle())) {
            throw new RuntimeException("La película '" + movie.getTitle() + "' ya existe.");
        }
        movie.setId(null);
        return movieRepository.save(movie);
    }

    public Movie putMovieById(Integer id,Movie updatedMovie){
        if(movieRepository.existsById(id)){
            updatedMovie.setId(id);
            return movieRepository.save(updatedMovie);
        }else{
            return null;
        }
    }

    public void deleteMoviebyId(Integer id){
        movieRepository.deleteById(id);
    }


}
