package com.accenture.challenge.model.comments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;
}
