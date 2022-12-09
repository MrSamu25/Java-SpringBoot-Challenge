package com.accenture.challenge.service;

import com.accenture.challenge.model.comments.Comment;
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
class CommentServiceImplTest {

    @InjectMocks
    private CommentServiceImpl commentServiceImpl;
    @Mock
    private RestTemplate restTemplate;
    private ResponseEntity<List<Comment>> responseEntity;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(commentServiceImpl, "baseUrl", "dummy base url");
        ReflectionTestUtils.setField(commentServiceImpl, "commentsUrl", "dummy comments url");

        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setId(3L);
        commentList.add(comment);

        responseEntity = new ResponseEntity<>(commentList, HttpStatusCode.valueOf(200));
    }

    @Test
    void shouldGetAllComments() {
        given(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(ParameterizedTypeReference.class)))
                .willReturn(responseEntity);

        List<Comment> commentList = commentServiceImpl.getAllComments("comment name");

        Assertions.assertEquals(3L, commentList.get(0).getId());
    }

}
