package com.accenture.challenge.controller;

import com.accenture.challenge.business.PhotoBusiness;
import com.accenture.challenge.model.photo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoController {
    @Autowired
    private PhotoBusiness photoBusiness;

    @GetMapping("/photos")
    public List<Photo> getAllPhotos(@RequestParam(required = false) String albumId,
                                   @RequestParam(required = false) String id,
                                   @RequestParam(required = false) String title) {
        return photoBusiness.getAllPhotos(albumId, id, title);
    }

    @GetMapping("/users/{userId}/photos")
    public List<Photo> getPhotosByUserId(@PathVariable String userId) {
        return photoBusiness.getPhotosByUserId(userId);
    }
}
