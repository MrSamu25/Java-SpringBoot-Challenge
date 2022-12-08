package com.accenture.challenge.repository;

import com.accenture.challenge.entity.SharedAlbumEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SharedAlbumRepository extends CrudRepository<SharedAlbumEntity, Long> {
    List<SharedAlbumEntity> findAll();
    SharedAlbumEntity save(SharedAlbumEntity sharedAlbumEntity);
}
