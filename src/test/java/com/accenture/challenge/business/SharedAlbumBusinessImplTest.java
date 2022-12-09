package com.accenture.challenge.business;

import com.accenture.challenge.entity.AlbumEntity;
import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.exception.BusinessException;
import com.accenture.challenge.model.sharedAlbum.SharedAlbum;
import com.accenture.challenge.model.sharedAlbum.SharedAlbumUpdate;
import com.accenture.challenge.repository.AlbumRepository;
import com.accenture.challenge.repository.SharedAlbumRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SharedAlbumBusinessImplTest {

    @InjectMocks
    private SharedAlbumBusinessImpl sharedAlbumBusinessImpl;
    @Mock
    private SharedAlbumRepository sharedAlbumRepository;
    @Mock
    private AlbumRepository albumRepository;
    private List<SharedAlbumEntity> sharedAlbumEntityList;
    private Optional<AlbumEntity> optionalAlbumEntity;
    private Optional<SharedAlbumEntity> optionalSharedAlbumEntity;
    private SharedAlbum sharedAlbum;
    private SharedAlbumEntity sharedAlbumEntity2;
    private SharedAlbumUpdate sharedAlbumUpdate;

    @BeforeEach
    void setUp() {
        sharedAlbumEntityList = new ArrayList<>();
        SharedAlbumEntity sharedAlbumEntity = new SharedAlbumEntity();
        sharedAlbumEntity.setId(5L);
        sharedAlbumEntityList.add(sharedAlbumEntity);

        AlbumEntity albumEntity = new AlbumEntity();
        optionalAlbumEntity = Optional.of(albumEntity);

        optionalSharedAlbumEntity = Optional.of(sharedAlbumEntity);

        sharedAlbum = new SharedAlbum();
        sharedAlbum.setAlbumId(1L);
        sharedAlbum.setUserIdDestination(2L);
        sharedAlbum.setUserIdSource(4L);
        sharedAlbum.setRead(true);
        sharedAlbum.setWrite(false);

        sharedAlbumEntity2 = new SharedAlbumEntity();
        sharedAlbumEntity2.setId(1L);
        sharedAlbumEntity2.setAlbumId(1L);
        sharedAlbumEntity2.setUserIdDestination(2L);
        sharedAlbumEntity2.setUserIdSource(4L);
        sharedAlbumEntity2.setRead(true);
        sharedAlbumEntity2.setWrite(false);

        sharedAlbumUpdate = new SharedAlbumUpdate();
        sharedAlbumUpdate.setId(1L);
        sharedAlbumUpdate.setAlbumId(1L);
        sharedAlbumUpdate.setUserIdDestination(2L);
        sharedAlbumUpdate.setUserIdSource(4L);
        sharedAlbumUpdate.setRead(true);
        sharedAlbumUpdate.setWrite(false);
    }

    @Test
    void shouldGetAllSharedAlbum() {
        given(sharedAlbumRepository.findAll()).willReturn(sharedAlbumEntityList);

        List<SharedAlbumEntity> sharedAlbumEntityList2 = sharedAlbumBusinessImpl.getAllSharedAlbum();

        Assertions.assertEquals(5L, sharedAlbumEntityList2.get(0).getId());
    }

    @Test
    void shouldSaveSharedAlbum() {
        given(albumRepository.findByIdAndUserId(anyLong(), anyLong())).willReturn(optionalAlbumEntity);
        given(sharedAlbumRepository.save(any(SharedAlbumEntity.class))).willReturn(sharedAlbumEntity2);

        SharedAlbum sharedAlbum2 = sharedAlbumBusinessImpl.saveSharedAlbum(sharedAlbum);
        Assertions.assertEquals(4L, sharedAlbum2.getUserIdSource());
    }

    @Test
    void shouldThrowAnErrorWhenSaveSharedAlbum() {
        sharedAlbum.setUserIdSource(2L);
        BusinessException businessException = Assertions.assertThrows(BusinessException.class, () -> {
            sharedAlbumBusinessImpl.saveSharedAlbum(sharedAlbum);
        });
        Assertions.assertEquals("userIdSource and userIdDestination can not be the same",
                businessException.getMessage());
    }

    @Test
    void shouldThrowAnErrorWhenSaveSharedAlbumDifferentOwner() {
        BusinessException businessException = Assertions.assertThrows(BusinessException.class, () -> {
            optionalAlbumEntity = Optional.empty();
            given(albumRepository.findByIdAndUserId(anyLong(), anyLong())).willReturn(optionalAlbumEntity);
            sharedAlbumBusinessImpl.saveSharedAlbum(sharedAlbum);
        });
        Assertions.assertEquals("Source user with id: 4 doesn't has album with id: 1",
                businessException.getMessage());
    }

    @Test
    void shouldUpdateSharedAlbum() {
        given(albumRepository.findByIdAndUserId(anyLong(), anyLong())).willReturn(optionalAlbumEntity);
        given(sharedAlbumRepository.findById(anyLong())).willReturn(optionalSharedAlbumEntity);
        given(sharedAlbumRepository.save(any(SharedAlbumEntity.class))).willReturn(sharedAlbumEntity2);

        SharedAlbumUpdate sharedAlbumUpdateResult = sharedAlbumBusinessImpl.updateSharedAlbum(sharedAlbumUpdate);

        Assertions.assertTrue(sharedAlbumUpdateResult.isRead());
        Assertions.assertFalse(sharedAlbumUpdateResult.isWrite());
    }

    @Test
    void shouldThrowAnErrorWhenUpdateSharedAlbum() {
        BusinessException businessException = Assertions.assertThrows(BusinessException.class, () -> {
            given(albumRepository.findByIdAndUserId(anyLong(), anyLong())).willReturn(optionalAlbumEntity);
            given(sharedAlbumRepository.findById(anyLong())).willReturn(Optional.empty());

            sharedAlbumBusinessImpl.updateSharedAlbum(sharedAlbumUpdate);
        });
        Assertions.assertEquals("Shared Album does not exists", businessException.getMessage());
    }
}
