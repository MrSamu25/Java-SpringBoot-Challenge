package com.accenture.challenge.controller;

import com.accenture.challenge.business.PhotoBusiness;
import com.accenture.challenge.model.photo.Photo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PhotoControllerTest {

    @InjectMocks
    private PhotoController photoController;
    @Mock
    private PhotoBusiness photoBusiness;
    private List<Photo> photoList;

    @BeforeEach
    void setUp() {
        photoList = new ArrayList<>();
        Photo photo = new Photo();
        photo.setTitle("some exciting title");
        photo.setThumbnailUrl("dummny thumbnail url");
        photoList.add(photo);
    }

    @Test
    void shouldGetAllPhotos() {
        given(photoBusiness.getAllPhotos(anyString(), anyString(), anyString())).willReturn(photoList);

        List<Photo> photoListResult = photoController.getAllPhotos(anyString(), anyString(), anyString());

        Assertions.assertEquals("some exciting title", photoListResult.get(0).getTitle());
    }

    @Test
    void shouldGetPhotosByUserId() {
        given(photoBusiness.getPhotosByUserId(anyString())).willReturn(photoList);

        List<Photo> photoListResult = photoController.getPhotosByUserId(anyString());

        Assertions.assertEquals("dummny thumbnail url", photoListResult.get(0).getThumbnailUrl());
    }
}
