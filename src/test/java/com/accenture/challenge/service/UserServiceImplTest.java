package com.accenture.challenge.service;

import com.accenture.challenge.model.user.User;
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
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private RestTemplate restTemplate;
    private ResponseEntity<List<User>> responseEntity;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(userServiceImpl, "baseUrl", "dummy base url");
        ReflectionTestUtils.setField(userServiceImpl, "usersUrl", "dummy users url");

        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        userList.add(user);

        responseEntity = new ResponseEntity<>(userList, HttpStatusCode.valueOf(200));
    }

    @Test
    void shouldGetAllUsers() {
        given(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class)))
                .willReturn(responseEntity);

        List<User> userList = userServiceImpl.getAllUsers("1", "samuriel", "samu@gmail.com");

        Assertions.assertEquals(1L, userList.get(0).getId());
    }

}
