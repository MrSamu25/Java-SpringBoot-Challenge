package com.accenture.challenge.mapper;

import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.model.sharedAlbum.SharedAlbum;
import com.accenture.challenge.model.sharedAlbum.SharedAlbumUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SharedAlbumMapper {

    SharedAlbumMapper mapper = Mappers.getMapper(SharedAlbumMapper.class);

    SharedAlbumEntity sharedAlbumToSharedAlbumEntity(SharedAlbum sharedAlbum);

    SharedAlbum sharedAlbumEntityToSharedAlbum(SharedAlbumEntity sharedAlbumEntity);

    List<SharedAlbum> sharedAlbumEntityListToSharedAlbumList(List<SharedAlbumEntity> sharedAlbumEntityList);


    SharedAlbumEntity sharedAlbumUpdateToSharedAlbumEntity(SharedAlbumUpdate sharedAlbumUpdate);

    SharedAlbumUpdate sharedAlbumEntityToSharedAlbumUpdate(SharedAlbumEntity sharedAlbumEntity);
}
