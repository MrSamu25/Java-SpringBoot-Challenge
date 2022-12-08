package com.accenture.challenge.business;

import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.exception.BusinessException;
import com.accenture.challenge.model.sharedAlbum.SharedAlbum;
import com.accenture.challenge.model.sharedAlbum.SharedAlbumUpdate;

import java.util.List;

public interface SharedAlbumBusiness {
    List<SharedAlbumEntity> getAllSharedAlbum();

    SharedAlbum saveSharedAlbum(SharedAlbum sharedAlbum) throws BusinessException;

    SharedAlbumUpdate updateSharedAlbum(SharedAlbumUpdate sharedAlbumUpdate) throws BusinessException;
}
