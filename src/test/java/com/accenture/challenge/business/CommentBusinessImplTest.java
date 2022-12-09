package com.accenture.challenge.business;

import com.accenture.challenge.model.comments.Comment;
import com.accenture.challenge.service.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CommentBusinessImplTest {

    @InjectMocks
    private CommentBusinessImpl commentBusinessImpl;
    @Mock
    private CommentService commentService;
    private List<Comment> commentList;

    @BeforeEach
    void setUp() {
        commentList = new ArrayList<>();
        Comment comment = new Comment();
        commentList.add(comment);
    }

    @Test
    void shouldGetAllComments() {
        given(commentService.getAllComments(anyString())).willReturn(commentList);

        List<Comment> commentListResult = commentBusinessImpl.getAllComments("1", 1L);

        Assertions.assertEquals(1, commentListResult.size());
    }
}
