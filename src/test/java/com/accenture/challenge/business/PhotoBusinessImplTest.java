package com.accenture.challenge.business;

import com.accenture.challenge.model.album.Album;
import com.accenture.challenge.model.photo.Photo;
import com.accenture.challenge.service.AlbumService;
import com.accenture.challenge.service.PhotoService;
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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PhotoBusinessImplTest {

    @InjectMocks
    private PhotoBusinessImpl photoBusinessImpl;
    @Mock
    private PhotoService photoService;
    @Mock
    private AlbumService albumService;
    private List<Photo> photoList;
    private List<Album> albumList;

    @BeforeEach
    void setUp() {
        photoList = new ArrayList<>();
        Photo photo = new Photo();
        photo.setTitle("some attractive title");
        photoList.add(photo);

        albumList = new ArrayList<>();
        Album album = new Album();
        album.setId(10L);
        album.setTitle("another attractive title");
        albumList.add(album);
    }

    @Test
    void shouldGetAllPhotos() {
        given(photoService.getAllPhotos(anyString(), anyString(), anyString())).willReturn(photoList);

        List<Photo> photoListResult = photoBusinessImpl.getAllPhotos(anyString(), anyString(), anyString());

        Assertions.assertEquals("some attractive title", photoListResult.get(0).getTitle());
    }

    @Test
    void shouldGetPhotosByUserId() {
        given(albumService.getAllAlbums(anyString(), isNull(), isNull())).willReturn(albumList);
        given(photoService.getAllPhotos(anyString(), isNull(), isNull())).willReturn(photoList);

        List<Photo> photoListResult = photoBusinessImpl.getPhotosByUserId("1");

        Assertions.assertEquals("some attractive title", photoListResult.get(0).getTitle());

    }
}
