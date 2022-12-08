package com.accenture.challenge.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user", schema = "public")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
}
