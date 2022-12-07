package com.accenture.challenge.business;

import com.accenture.challenge.model.album.Album;

import java.util.List;

public interface AlbumBusiness {
    List<Album> getAllAlbums(String userId, String id, String title);
}
