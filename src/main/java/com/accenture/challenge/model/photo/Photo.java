package com.accenture.challenge.model.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    private String albumId;
    private String id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
