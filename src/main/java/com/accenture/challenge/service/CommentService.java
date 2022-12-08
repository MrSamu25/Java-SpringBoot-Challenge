package com.accenture.challenge.service;

import com.accenture.challenge.model.comments.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments(String name);
}
