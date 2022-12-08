package com.accenture.challenge.service;

import com.accenture.challenge.model.comments.Comment;
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
public class CommentServiceImpl implements CommentService {
    @Value("${url.base}")
    private String baseUrl;
    @Value("${url.comments}")
    private String commentsUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Comment> getAllComments(String name) {
        String path = buildPath(baseUrl.concat(commentsUrl), name);
        ResponseEntity<List<Comment>> responseEntity = restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        return responseEntity.getBody();
    }

    private String buildPath(String url, String name) {
        String result = url.concat("?");
        if (null != name && StringUtils.hasLength(name.trim())) {
            result = result.concat("name=").concat(name);
        }

        return result;
    }

}
