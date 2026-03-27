package com.HorrorReviewerV2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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


}
