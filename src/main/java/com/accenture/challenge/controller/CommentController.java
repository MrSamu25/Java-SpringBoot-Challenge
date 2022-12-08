package com.accenture.challenge.controller;

import com.accenture.challenge.business.CommentBusiness;
import com.accenture.challenge.model.comments.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentBusiness commentBusiness;

    @GetMapping("/comments")
    public List<Comment> getAllComments(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Long userId) {
        return commentBusiness.getAllComments(name, userId);
    }
}
