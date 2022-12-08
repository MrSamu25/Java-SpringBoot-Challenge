package com.accenture.challenge.repository;

import com.accenture.challenge.entity.AlbumEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
    Optional<AlbumEntity> findByIdAndUserId(Long id, Long userId);
}
