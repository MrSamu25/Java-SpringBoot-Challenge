package com.accenture.challenge.business;

import com.accenture.challenge.model.comments.Comment;
import com.accenture.challenge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentBusinessImpl implements CommentBusiness {

    @Autowired
    private CommentService commentService;

    @Override
    public List<Comment> getAllComments(String name, Long userId) {
        return commentService.getAllComments(name);
    }
}
