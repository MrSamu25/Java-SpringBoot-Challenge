package com.accenture.challenge.business;

import com.accenture.challenge.model.comments.Comment;

import java.util.List;

public interface CommentBusiness {
    List<Comment> getAllComments(String name, Long userId);
}
