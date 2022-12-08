package com.accenture.challenge.mapper;

import com.accenture.challenge.entity.AlbumEntity;
import com.accenture.challenge.model.album.Album;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlbumMapper {
    AlbumMapper mapper = Mappers.getMapper(AlbumMapper.class);

    List<AlbumEntity> albumListToAlbumEntityList(List<Album> userList);

}
