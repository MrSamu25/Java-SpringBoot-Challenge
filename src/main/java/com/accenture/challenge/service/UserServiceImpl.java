package com.accenture.challenge.service;

import com.accenture.challenge.model.user.User;
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
public class UserServiceImpl implements UserService {
    @Value("${url.base}")
    private String baseUrl;
    @Value("${url.users}")
    private String usersUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getAllUsers(String id, String username, String email) {
        String path = buildPath(baseUrl.concat(usersUrl), id, username, email);
        System.out.println(path);
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                });
        return responseEntity.getBody();
    }

    private String buildPath(String url, String id, String username, String email) {
        String result = url.concat("?");
        if (null != id && StringUtils.hasLength(id.trim())) {
            result = result.concat("id=").concat(id).concat("&");
        }

        if (null != username && StringUtils.hasLength(username.trim())) {
            result = result.concat("username=").concat(username).concat("&");
        }

        if (null != email && StringUtils.hasLength(email.trim())) {
            result = result.concat("email=").concat(email);
        }

        return result;
    }

}
