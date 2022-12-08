package com.accenture.challenge.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "album", schema = "public")
@Data
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userid")
    private Long userId;
    @Column(name = "title")
    private String title;
}
