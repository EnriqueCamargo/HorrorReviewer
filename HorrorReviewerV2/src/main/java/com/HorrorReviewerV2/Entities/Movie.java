package com.HorrorReviewerV2.Entities;

import com.HorrorReviewerV2.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
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

    public Movie() {
    }

    public Movie(String title, Integer length, Genre genre, LocalDate releaseDate, boolean available, Director director) {
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.available = available;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
