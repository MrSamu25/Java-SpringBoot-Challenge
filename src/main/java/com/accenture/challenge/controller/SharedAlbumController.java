package com.accenture.challenge.controller;

import com.accenture.challenge.business.SharedAlbumBusiness;
import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.exception.BusinessException;
import com.accenture.challenge.model.sharedAlbum.SharedAlbum;
import com.accenture.challenge.model.sharedAlbum.SharedAlbumUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public SharedAlbum saveSharedAlbum(@RequestBody SharedAlbum sharedAlbum) throws BusinessException {
        return sharedAlbumBusiness.saveSharedAlbum(sharedAlbum);
    }

    @PutMapping("/sharedAlbums")
    public SharedAlbumUpdate updateSharedAlbum(@RequestBody SharedAlbumUpdate sharedAlbumUpdate) throws BusinessException {
        return sharedAlbumBusiness.updateSharedAlbum(sharedAlbumUpdate);
    }

}
