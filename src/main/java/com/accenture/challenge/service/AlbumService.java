package com.accenture.challenge.service;

import com.accenture.challenge.model.album.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums(String userId, String id, String title);
}
