package com.accenture.challenge.business;

import com.accenture.challenge.entity.AlbumEntity;
import com.accenture.challenge.mapper.AlbumMapper;
import com.accenture.challenge.model.album.Album;
import com.accenture.challenge.repository.AlbumRepository;
import com.accenture.challenge.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumBusinessImpl implements AlbumBusiness {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums(String userId, String id, String title) {
        List<Album> albumList = albumService.getAllAlbums(userId, id, title);
        saveAllAlbums(albumList);
        return albumList;
    }

    private void saveAllAlbums(List<Album> albumList) {
        List<AlbumEntity> userEntityList = AlbumMapper.mapper.albumListToAlbumEntityList(albumList);
        albumRepository.saveAll(userEntityList);
    }
}
