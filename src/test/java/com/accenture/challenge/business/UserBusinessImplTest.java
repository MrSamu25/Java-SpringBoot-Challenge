package com.accenture.challenge.business;

import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.entity.UserEntity;
import com.accenture.challenge.model.user.User;
import com.accenture.challenge.repository.SharedAlbumRepository;
import com.accenture.challenge.repository.UserRepository;
import com.accenture.challenge.service.UserService;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserBusinessImplTest {

    @InjectMocks
    private UserBusinessImpl userBusinessImpl;
    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private SharedAlbumRepository sharedAlbumRepository;
    private List<User> userList;
    private List<SharedAlbumEntity> sharedAlbumEntityList;
    private Optional<UserEntity> optionalUserEntity;

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        userList.add(user);
        User user2 = new User();
        user2.setId(2L);
        userList.add(user2);

        sharedAlbumEntityList = new ArrayList<>();
        SharedAlbumEntity sharedAlbumEntity = new SharedAlbumEntity();
        sharedAlbumEntity.setId(1L);
        sharedAlbumEntity.setAlbumId(1L);
        sharedAlbumEntity.setUserIdDestination(2L);
        sharedAlbumEntity.setUserIdSource(4L);
        sharedAlbumEntity.setRead(true);
        sharedAlbumEntity.setWrite(false);
        sharedAlbumEntityList.add(sharedAlbumEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("samu@gmail.com");
        optionalUserEntity = Optional.of(userEntity);
    }

    @Test
    void shouldGetAllUsers() {
        given(userService.getAllUsers(anyString(), anyString(), anyString()))
                .willReturn(userList);

        List<User> userList = userBusinessImpl.getAllUsers("1", "username", "samu@gmail.com");

        Assertions.assertEquals(1L, userList.get(0).getId());
        Assertions.assertEquals(2L, userList.get(1).getId());
    }

    @Test
    void shouldGetUsersByPermissions() {
        given(sharedAlbumRepository.findByAlbumIdAndReadAndWrite(anyLong(), anyBoolean(), anyBoolean()))
                .willReturn(sharedAlbumEntityList);

        given(userRepository.findById(anyLong()))
                .willReturn(optionalUserEntity);

        List<User> userList = userBusinessImpl.getUsersByPermissions(1L, true, false);

        Assertions.assertEquals("samu@gmail.com", userList.get(0).getEmail());
    }
}
