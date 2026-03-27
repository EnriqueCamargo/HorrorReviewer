package com.HorrorReviewerV2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "rating", nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt=LocalDateTime.now();

    @JoinColumn(name = "movie_id")
    @ManyToOne
    @JsonIgnoreProperties({"reviews", "director","available","releasedate","length"})
    private Movie movie;
    @JoinColumn(name = "user_id")
    @ManyToOne
    @JsonIgnoreProperties({"email","role","password","reviews"})
    private User user;

    public Review(Integer id, BigDecimal rating, String comment, LocalDateTime createdAt, Movie movie, User user) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
        this.movie = movie;
        this.user = user;
    }

    public Review() {
    }
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
