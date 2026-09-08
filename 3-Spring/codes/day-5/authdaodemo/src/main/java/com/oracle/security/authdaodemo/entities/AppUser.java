package com.oracle.security.authdaodemo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String username;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String password;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String role;

    public AppUser() {
    }

    public AppUser(Long id, @NotNull @NotBlank String username, @NotNull @NotBlank String password,
                   @NotNull @NotBlank String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
