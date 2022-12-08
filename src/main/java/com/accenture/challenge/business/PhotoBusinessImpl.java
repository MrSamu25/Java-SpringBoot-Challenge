package com.accenture.challenge.business;

import com.accenture.challenge.model.album.Album;
import com.accenture.challenge.model.photo.Photo;
import com.accenture.challenge.service.AlbumService;
import com.accenture.challenge.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhotoBusinessImpl implements PhotoBusiness {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private AlbumService albumService;

    @Override
    public List<Photo> getAllPhotos(String albumId, String id, String title) {
        return photoService.getAllPhotos(albumId, id, title);
    }

    @Override
    public List<Photo> getPhotosByUserId(String userId) {
        List<Photo> userPhotos = new ArrayList<>();
        List<Album> albums = albumService.getAllAlbums(userId, null, null);
        for (Album album : albums) {
            userPhotos.addAll(photoService.getAllPhotos(String.valueOf(album.getId()), null, null));
        }
        return userPhotos;
    }
}
