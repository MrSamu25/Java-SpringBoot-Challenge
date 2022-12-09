package com.accenture.challenge.controller;

import com.accenture.challenge.business.SharedAlbumBusiness;
import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.model.sharedAlbum.SharedAlbum;
import com.accenture.challenge.model.sharedAlbum.SharedAlbumUpdate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SharedAlbumControllerTest {

    @InjectMocks
    private SharedAlbumController sharedAlbumController;
    @Mock
    private SharedAlbumBusiness sharedAlbumBusiness;
    private List<SharedAlbumEntity> sharedAlbumEntityList;
    private SharedAlbum sharedAlbum;
    private SharedAlbumUpdate sharedAlbumUpdate;

    @BeforeEach
    void setUp() {
        sharedAlbumEntityList = new ArrayList<>();
        SharedAlbumEntity sharedAlbumEntity = new SharedAlbumEntity();
        sharedAlbumEntityList.add(sharedAlbumEntity);

        sharedAlbum = new SharedAlbum();
        sharedAlbum.setRead(false);
        sharedAlbum.setWrite(true);

        sharedAlbumUpdate = new SharedAlbumUpdate();
        sharedAlbumUpdate.setUserIdSource(1L);
        sharedAlbumUpdate.setUserIdDestination(2L);
    }

    @Test
    void shouldGetAllSharedAlbum() {
        given(sharedAlbumBusiness.getAllSharedAlbum()).willReturn(sharedAlbumEntityList);

        List<SharedAlbumEntity> sharedAlbumEntityListResult = sharedAlbumController.getAllSharedAlbum();

        Assertions.assertEquals(1, sharedAlbumEntityListResult.size());
    }

    @Test
    void shouldSaveSharedAlbum() {
        given(sharedAlbumBusiness.saveSharedAlbum(any())).willReturn(sharedAlbum);

        SharedAlbum sharedAlbumResult = sharedAlbumController.saveSharedAlbum(any());

        Assertions.assertFalse(sharedAlbumResult.isRead());
        Assertions.assertTrue(sharedAlbumResult.isWrite());
    }

    @Test
    void shouldUpdateSharedAlbum() {
        given(sharedAlbumBusiness.updateSharedAlbum(any())).willReturn(sharedAlbumUpdate);

        SharedAlbumUpdate sharedAlbumUpdateResult = sharedAlbumController.updateSharedAlbum(any());

        Assertions.assertEquals(1L, sharedAlbumUpdateResult.getUserIdSource());
        Assertions.assertEquals(2L, sharedAlbumUpdateResult.getUserIdDestination());
    }

}
