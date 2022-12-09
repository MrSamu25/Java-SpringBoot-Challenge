package com.accenture.challenge.controller;

import com.accenture.challenge.business.AlbumBusiness;
import com.accenture.challenge.model.album.Album;
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
class AlbumControllerTest {

    @InjectMocks
    private AlbumController albumController;
    @Mock
    private AlbumBusiness albumBusiness;
    private List<Album> albumList;

    @BeforeEach
    void setUp() {
        albumList = new ArrayList<>();
        Album album = new Album();
        album.setTitle("dummy title");
        albumList.add(album);
    }

    @Test
    void shouldGetAllAlbums() {
        given(albumBusiness.getAllAlbums(anyString(), anyString(), anyString())).willReturn(albumList);

        List<Album> albumListResult = albumController.getAllAlbums(anyString(), anyString(), anyString());

        Assertions.assertEquals("dummy title", albumListResult.get(0).getTitle());
    }
}
