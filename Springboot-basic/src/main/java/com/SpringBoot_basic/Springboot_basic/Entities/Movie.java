package com.SpringBoot_basic.Springboot_basic.Entities;

import com.SpringBoot_basic.Springboot_basic.Enums.Genre;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    @Column(name="releaseDate",nullable = false)
    private LocalDate releaseDate;
    @Column(name = "rating", nullable = false)
    private BigDecimal rating;
    @Column(name="available",nullable = false)
    private boolean available;
    @ManyToOne
    @JoinColumn(name = "directorId",nullable = false)
    private Director director;

    protected Movie() {
    }

    public Movie(String title, Integer length, Genre genre, LocalDate releaseDate, BigDecimal rating, boolean available, Director director) {
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
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

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
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
