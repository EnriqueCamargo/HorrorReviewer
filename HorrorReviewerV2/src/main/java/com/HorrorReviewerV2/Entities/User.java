package com.HorrorReviewerV2.Entities;

import com.HorrorReviewerV2.Enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name ="email",nullable = false,unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;
    @Column(name = "password",nullable = false)
    private String password;


    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Review> reviews;

    public User(String username, Integer id, String email, Role role, String password) {
        this.username = username;
        this.id = id;
        this.email = email;
        this.role = role;
        this.password = password;
    }
    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
