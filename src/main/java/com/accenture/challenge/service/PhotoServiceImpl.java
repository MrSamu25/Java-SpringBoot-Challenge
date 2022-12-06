package com.accenture.challenge.service;

import com.accenture.challenge.model.photo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Value("${url.base}")
    private String baseUrl;
    @Value("${url.photos}")
    private String photosUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Photo> getAllPhotos(String albumId, String id, String title) {
        String path = buildPath(baseUrl.concat(photosUrl), albumId, id, title);
        System.out.println(path);
        ResponseEntity<List<Photo>> responseEntity = restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Photo>>() {
                });
        return responseEntity.getBody();
    }

    private String buildPath(String url, String albumId, String id, String title) {
        String result = url.concat("?");
        if (null != albumId && StringUtils.hasLength(albumId.trim())) {
            result = result.concat("albumId=").concat(albumId).concat("&");
        }

        if (null != id && StringUtils.hasLength(id.trim())) {
            result = result.concat("id=").concat(id).concat("&");
        }

        if (null != title && StringUtils.hasLength(title.trim())) {
            result = result.concat("title=").concat(title);
        }

        return result;
    }

}
