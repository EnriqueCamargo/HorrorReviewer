package com.HorrorReviewerV2.Entities;

import com.HorrorReviewerV2.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title",nullable = false,length = 50)
    private String title;
    @Column(name="length",nullable = false)
    private Integer length;
    @Enumerated(EnumType.STRING)
    @Column(name="genre",nullable = false,length = 50)
    private Genre genre;
    @Column(name="releasedate",nullable = false)
    private LocalDate releaseDate;
    @Column(name="available",nullable = false)
    private boolean available;
    @ManyToOne
    @JsonIgnoreProperties("movieList")
    @JoinColumn(name = "directorid",nullable = false)
    private Director director;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

}
