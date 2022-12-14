package com.accenture.challenge.model.album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private Long id;
    private Long userId;
    private String title;
}
