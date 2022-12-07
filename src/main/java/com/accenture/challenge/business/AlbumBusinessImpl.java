package com.accenture.challenge.business;

import com.accenture.challenge.model.album.Album;
import com.accenture.challenge.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumBusinessImpl implements AlbumBusiness {
    @Autowired
    private AlbumService albumService;

    @Override
    public List<Album> getAllAlbums(String userId, String id, String title) {
        return albumService.getAllAlbums(userId, id, title);
    }
}
