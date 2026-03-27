package com.HorrorReviewerV2.Controllers;

import com.HorrorReviewerV2.Entities.Review;
import com.HorrorReviewerV2.Services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/api/reviews/")
    public ResponseEntity<?> getAllReviews(){
        try{
            return ResponseEntity.ok(reviewService.getAllReviews());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/api/reviews/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Integer id){
        try{
            Review review =reviewService.getReviewById(id);
            if(review!=null){
                return ResponseEntity.ok(review);

            }else{
                return ResponseEntity.status(404).body("Review No encontrada");
            }
             }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/api/reviews/movieId/{id}")
    public ResponseEntity<?> getAllReviewsByMovieId(@PathVariable Integer id){
        try {
            List<Review> reviewList=reviewService.getAllReviewsByMovieId(id);
            if(reviewList!=null){
                return ResponseEntity.ok(reviewList);
            }else {
                return ResponseEntity.status(404).body("No hay peliculas con el id "+id);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/api/reviews/movie/{movieTitle}")
    public ResponseEntity<?> getAllReviewsByMovieTitle(@PathVariable String movieTitle){
        try {
            List<Review> reviewList=reviewService.getAllReviewsbyMovieTitle(movieTitle);
            if(reviewList!=null){
                return ResponseEntity.ok(reviewList);

            }else {
                return ResponseEntity.status(404).body("No existe pelicula con titulo "+movieTitle);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/api/reviews/user/{username}")
    public ResponseEntity<?> getAllReviewsByUsername(@PathVariable String username){
        try {
            List<Review> reviewList=reviewService.getAllReviewsByUserName(username);
            if(reviewList!=null){
                return ResponseEntity.ok(reviewList);
            }else {
                return ResponseEntity.status(404).body("no existe Usuario "+username);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/api/reviews/userId/{id}")
    public ResponseEntity<?> getAllReviewsByUserId(@PathVariable Integer id){
        try {
            List<Review> reviewList=reviewService.getAllReviewsByUserId(id);
            if(reviewList!=null){
                return ResponseEntity.ok(reviewList);
            }else {
                return ResponseEntity.status(404).body("no existe Usuario "+id);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/api/reviews/")
    public ResponseEntity<?> postReview(@RequestBody Review review){
        try {
            return ResponseEntity.ok(reviewService.postReview(review));
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    @PutMapping("/api/reviews/update/{id}")
    public ResponseEntity<?> putReview(@PathVariable Integer id,@RequestBody Review review){
        try {
            Review updatedReview =reviewService.putReview(id,review);
            if(updatedReview!=null){
                return ResponseEntity.ok(updatedReview);

            }else{
                return ResponseEntity.status(404).body("No existe el usuario +"+id);
            }
            }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @DeleteMapping("/api/reviews/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer id){
        try {
            if(reviewService.deleteReview(id)){
                return ResponseEntity.ok("Review Eliminada exitosamente");
            }else{
                return ResponseEntity.status(404).body("Review No encontrada con id "+id);
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
