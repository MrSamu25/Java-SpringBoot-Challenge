package com.accenture.challenge.business;

import com.accenture.challenge.entity.SharedAlbumEntity;

import java.util.List;

public interface SharedAlbumBusiness {
    List<SharedAlbumEntity> getAllSharedAlbum();

    SharedAlbumEntity saveSharedAlbum(SharedAlbumEntity sharedAlbumEntity);
}
