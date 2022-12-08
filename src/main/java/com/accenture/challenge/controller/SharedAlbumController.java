package com.accenture.challenge.controller;

import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.business.SharedAlbumBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SharedAlbumController {

    @Autowired
    private SharedAlbumBusiness sharedAlbumBusiness;

    @GetMapping("/sharedAlbums")
    public List<SharedAlbumEntity> getAllSharedAlbum() {
        return sharedAlbumBusiness.getAllSharedAlbum();
    }

    @PostMapping("/sharedAlbums")
    public SharedAlbumEntity saveSharedAlbum(@RequestBody SharedAlbumEntity sharedAlbumEntity) {
        return sharedAlbumBusiness.saveSharedAlbum(sharedAlbumEntity);
    }

}
