package com.accenture.challenge.controller;

import com.accenture.challenge.business.AlbumBusiness;
import com.accenture.challenge.model.album.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    private AlbumBusiness albumBusiness;

    @GetMapping("/albums")
    public List<Album> getAllAlbums(@RequestParam(required = false) String userId,
                                    @RequestParam(required = false) String id,
                                    @RequestParam(required = false) String title) {
        return albumBusiness.getAllAlbums(userId, id, title);
    }
}
