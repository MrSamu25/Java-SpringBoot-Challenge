package com.accenture.challenge.repository;

import com.accenture.challenge.entity.SharedAlbumEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SharedAlbumRepository extends CrudRepository<SharedAlbumEntity, Long> {
    List<SharedAlbumEntity> findAll();

    Optional<SharedAlbumEntity> findById(Long id);

    SharedAlbumEntity save(SharedAlbumEntity sharedAlbumEntity);
}
