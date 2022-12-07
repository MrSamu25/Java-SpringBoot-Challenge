package com.accenture.challenge.business;

import com.accenture.challenge.model.photo.Photo;

import java.util.List;

public interface PhotoBusiness {
    List<Photo> getAllPhotos(String albumId, String id, String title);

    List<Photo> getPhotosByUserId(String userId);
}
