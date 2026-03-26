package com.example.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "\"user\"")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "full_name", length = 64, nullable = true)
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;
}
