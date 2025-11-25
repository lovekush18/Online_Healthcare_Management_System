package com.healthcarepro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;  // PATIENT / DOCTOR / ADMIN

    public User() {}

    // getters and setters
}
