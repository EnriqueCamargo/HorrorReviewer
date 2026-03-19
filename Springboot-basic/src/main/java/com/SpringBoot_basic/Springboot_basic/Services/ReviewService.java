package com.SpringBoot_basic.Springboot_basic.Services;

import com.SpringBoot_basic.Springboot_basic.Entities.Review;
import com.SpringBoot_basic.Springboot_basic.Repositories.MovieRepository;
import com.SpringBoot_basic.Springboot_basic.Repositories.ReviewRepository;
import com.SpringBoot_basic.Springboot_basic.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review getReviewById(Integer id){
        return reviewRepository.findById(id).orElse(null);
    }
    public List<Review> getAllReviewsByMovieId(Integer id){
        if(movieRepository.existsById(id)){
            List<Review> reviewList=reviewRepository.findAll();
            return reviewList.stream().filter(review -> review.getMovie().getId()==id).toList();
        }else {
            return null;
        }
    }
    public List<Review> getAllReviewsbyMovieTitle(String title){
        if(movieRepository.existsByTitle(title)){
            List<Review> reviewList=reviewRepository.findAll();
            return reviewList.stream().filter(review -> review.getMovie().getTitle()==title).toList();
        }else{
            return null;
        }
    }
    public List<Review> getAllReviewsByUserId(Integer id){
        if(userRepository.existsById(id)){
            List<Review> reviewList= reviewRepository.findAll();
            return reviewList.stream().filter(review -> review.getUser().getId()==id).toList();
        }else {
            return null;
        }
    }
    public List<Review> getAllReviewsByUserName(String username){
        if(userRepository.existsByUsername(username)){
            List<Review> reviewList= reviewRepository.findAll();
            return reviewList.stream().filter(review -> review.getUser().getUsername()==username).toList();
        }else {
            return null;
        }
    }

    public Review postReview(Review review){
        return reviewRepository.save(review);
    }
    public Review putReview(Integer id,Review review){
        if(reviewRepository.existsById(id)){
            review.setId(id);
            return reviewRepository.save(review);
        }else{
            return null;
        }
    }
    public Boolean deleteReview(Integer id){
        if(reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}

