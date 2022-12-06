package com.accenture.challenge.service;

import com.accenture.challenge.model.photo.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> getAllPhotos(String albumId, String id, String title);
}
