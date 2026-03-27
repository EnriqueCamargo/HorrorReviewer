package com.HorrorReviewerV2.Entities;

import com.HorrorReviewerV2.Enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
