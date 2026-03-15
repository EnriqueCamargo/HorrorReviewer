package com.SpringBoot_basic.Springboot_basic.Entities;

import com.SpringBoot_basic.Springboot_basic.Enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name ="email",nullable = false,unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "role",nullable = false)
    private Role role;

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
}
