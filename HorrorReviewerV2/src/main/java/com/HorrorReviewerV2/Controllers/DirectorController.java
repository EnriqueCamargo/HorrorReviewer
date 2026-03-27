package com.HorrorReviewerV2.Controllers;

import com.HorrorReviewerV2.Entities.Director;
import com.HorrorReviewerV2.Entities.Movie;
import com.HorrorReviewerV2.Services.DirectorService;
import com.HorrorReviewerV2.Services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {
    private final DirectorService directorService;
    private final MovieService movieService;
    public DirectorController(DirectorService directorService,MovieService movieService) {
        this.directorService = directorService;
        this.movieService=movieService;
    }

    @GetMapping("/api/directors")
    public ResponseEntity<?> getAllDirectores(){
        try {
            List<Director> directorList = directorService.getAllDirectores();
            return ResponseEntity.ok(directorList);
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/api/directors/{id}")
    public ResponseEntity<?> getDirectorById(@PathVariable Integer id){
        try{
            Director director=directorService.getDirectorById(id);
            if(director!=null){
                return ResponseEntity.ok(director);
            }else {
                return ResponseEntity.status(404).body("Director No encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
    @GetMapping("/api/directors/name/{name}")
    public ResponseEntity<?> getDirectorByName(@PathVariable String name){
        try{
            Director director=directorService.getDirectorByName(name);
            if(director!=null)
            {
                return ResponseEntity.ok(director);
            }else{
                return ResponseEntity.status(404).body("Director No encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
    @GetMapping("/api/directors/movies/{id}")
    public ResponseEntity<?> getMoviesByDirectorId(@PathVariable Integer id){
        try{
            List<Movie> movieList=directorService.getMoviesByDirectorId(id);
            if(!movieList.isEmpty()){
                return ResponseEntity.ok(movieList);
            }else {
                return ResponseEntity.status(404).body("No hay peliculas registradas del director con id: "+ id);
            }
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/api/directors/name/movies/{name}")
    public ResponseEntity<?> getMoviesByDirectorName(@PathVariable String name){
        try{
            List<Movie> movieList=directorService.getMoviesByDirectorName(name);
            if(!movieList.isEmpty()){
                return ResponseEntity.ok(movieList);

            }else {
                return ResponseEntity.status(404).body("No hay peliculas registradas con el director "+name);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/api/directors/")
    public ResponseEntity<?> postDirector(@RequestBody Director director){
        try {
            Director newDirector=directorService.postDirector(director);
            return ResponseEntity.status(201).body(newDirector);
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/api/directors/{id}")
    public ResponseEntity<?> putDirectorById(@PathVariable Integer id, @RequestBody Director director){
        try{
            Director UpdatedDirector=directorService.putDirectorById(id,director);
            if(UpdatedDirector!=null){
                return ResponseEntity.ok(UpdatedDirector);
            }else {
                return ResponseEntity.status(404).body("No hay un director con id "+id);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());

        }
    }
    @DeleteMapping("/api/directors/{id}")
    public ResponseEntity<?> deleteDirectorById(@PathVariable Integer id){
        try {
            if(directorService.deleteDirectorById(id)){
                return ResponseEntity.ok("Director Eliminado correctamente");
            }else{
                return ResponseEntity.status(404).body("Director No encontrado con id: "+id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
}
