package com.accenture.challenge.business;

import com.accenture.challenge.model.photo.Photo;
import com.accenture.challenge.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhotoBusinessImpl implements PhotoBusiness {

    @Autowired
    private PhotoService photoService;

    @Override
    public List<Photo> getAllPhotos(String albumId, String id, String title) {
        return photoService.getAllPhotos(albumId, id, title);
    }
}
