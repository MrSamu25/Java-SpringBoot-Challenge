package com.accenture.challenge.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shared_album", schema = "public")
@Data
public class SharedAlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "read")
    private boolean read;
    @Column(name = "write")
    private boolean write;
    @Column(name = "useridsource")
    private Long userIdSource;
    @Column(name = "useriddestination")
    private Long userIdDestination;
    @Column(name = "albumid")
    private Long albumId;
}
