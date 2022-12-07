package com.accenture.challenge.service;

import com.accenture.challenge.model.album.Album;
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
public class AlbumServiceImpl implements AlbumService {
    @Value("${url.base}")
    private String baseUrl;
    @Value("${url.albums}")
    private String albumsUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Album> getAllAlbums(String userId, String id, String title) {
        String path = buildPath(baseUrl.concat(albumsUrl), userId, id, title);
        ResponseEntity<List<Album>> responseEntity = restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        return responseEntity.getBody();
    }

    private String buildPath(String url, String userId, String id, String title) {
        String result = url.concat("?");
        if (null != userId && StringUtils.hasLength(userId.trim())) {
            result = result.concat("userId=").concat(userId).concat("&");
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
