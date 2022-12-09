package com.accenture.challenge.business;

import com.accenture.challenge.model.album.Album;
import com.accenture.challenge.repository.AlbumRepository;
import com.accenture.challenge.service.AlbumService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AlbumBusinessImplTest {

    @InjectMocks
    private AlbumBusinessImpl albumBusinessImpl;
    @Mock
    private AlbumService albumService;
    @Mock
    private AlbumRepository albumRepository;
    private List<Album> albumList;

    @BeforeEach
    void setUp() {
        albumList = new ArrayList<>();
        Album album = new Album();
        albumList.add(album);
    }

    @Test
    void shouldGetAllAlbums() {
        given(albumService.getAllAlbums(anyString(), anyString(), anyString())).willReturn(albumList);
        given(albumRepository.saveAll(any(List.class))).willReturn(null);

        List<Album> albumListResult = albumBusinessImpl.getAllAlbums(anyString(), anyString(), anyString());

        Assertions.assertEquals(1, albumListResult.size());
    }
}

