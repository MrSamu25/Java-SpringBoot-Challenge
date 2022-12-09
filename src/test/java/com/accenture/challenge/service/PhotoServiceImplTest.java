package com.accenture.challenge.service;

import com.accenture.challenge.model.photo.Photo;
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
class PhotoServiceImplTest {

    @InjectMocks
    private PhotoServiceImpl photoServiceImpl;
    @Mock
    private RestTemplate restTemplate;
    private ResponseEntity<List<Photo>> responseEntity;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(photoServiceImpl, "baseUrl", "dummy base url");
        ReflectionTestUtils.setField(photoServiceImpl, "photosUrl", "dummy photos url");

        List<Photo> photoList = new ArrayList<>();
        Photo photo = new Photo();
        photo.setId("2");
        photoList.add(photo);

        responseEntity = new ResponseEntity<>(photoList, HttpStatusCode.valueOf(200));
    }

    @Test
    void shouldGetAllPhotos() {
        given(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class)))
                .willReturn(responseEntity);

        List<Photo> photoList = photoServiceImpl.getAllPhotos("1", "1", "some title");

        Assertions.assertEquals("2", photoList.get(0).getId());
    }

}
