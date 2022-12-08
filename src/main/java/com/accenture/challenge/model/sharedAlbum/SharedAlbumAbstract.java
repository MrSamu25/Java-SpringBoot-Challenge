package com.accenture.challenge.model.sharedAlbum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class SharedAlbumAbstract {
    private boolean read;
    private boolean write;
    private Long userIdSource;
    private Long userIdDestination;
    private Long albumId;
}
