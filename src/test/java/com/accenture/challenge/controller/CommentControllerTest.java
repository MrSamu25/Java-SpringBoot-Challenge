package com.accenture.challenge.controller;

import com.accenture.challenge.business.CommentBusiness;
import com.accenture.challenge.model.comments.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {

    @InjectMocks
    private CommentController commentController;
    @Mock
    private CommentBusiness commentBusiness;
    private List<Comment> commentList;

    @BeforeEach
    void setUp() {
        commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setEmail("example@gmail.com");
        commentList.add(comment);
    }

    @Test
    void shouldGetAllComments() {
        given(commentBusiness.getAllComments(anyString(), anyLong())).willReturn(commentList);

        List<Comment> commentList = commentController.getAllComments(anyString(), anyLong());

        Assertions.assertEquals("example@gmail.com", commentList.get(0).getEmail());
    }
}
