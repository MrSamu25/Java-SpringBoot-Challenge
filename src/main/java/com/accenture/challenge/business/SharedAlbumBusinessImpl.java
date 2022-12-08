package com.accenture.challenge.business;

import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.repository.SharedAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SharedAlbumBusinessImpl implements SharedAlbumBusiness {

    @Autowired
    private SharedAlbumRepository sharedAlbumRepository;

    @Override
    public List<SharedAlbumEntity> getAllSharedAlbum() {
        return sharedAlbumRepository.findAll();
    }

    @Override
    public SharedAlbumEntity saveSharedAlbum(SharedAlbumEntity sharedAlbumEntity) {
        return sharedAlbumRepository.save(sharedAlbumEntity);
    }
}
