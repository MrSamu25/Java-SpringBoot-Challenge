package com.accenture.challenge.service;

import com.accenture.challenge.model.album.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl albumServiceImpl;
    @Mock
    private RestTemplate restTemplate;
    private ResponseEntity<List<Album>> responseEntity;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(albumServiceImpl, "baseUrl", "dummy base url");
        ReflectionTestUtils.setField(albumServiceImpl, "albumsUrl", "dummy albums url");

        List<Album> albumList = new ArrayList<>();
        Album album = new Album();
        album.setId(4L);
        albumList.add(album);

        responseEntity = new ResponseEntity<>(albumList, HttpStatusCode.valueOf(200));
    }

    @Test
    void shouldGetAllComments() {
        given(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class)))
                .willReturn(responseEntity);

        List<Album> albumList = albumServiceImpl.getAllAlbums("1", "2", "some tittle");

        Assertions.assertEquals(4L, albumList.get(0).getId());
    }
}
