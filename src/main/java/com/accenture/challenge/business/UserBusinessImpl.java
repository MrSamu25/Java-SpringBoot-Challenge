package com.accenture.challenge.business;

import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.entity.UserEntity;
import com.accenture.challenge.mapper.SharedAlbumMapper;
import com.accenture.challenge.mapper.UserMapper;
import com.accenture.challenge.model.sharedAlbum.SharedAlbum;
import com.accenture.challenge.model.user.User;
import com.accenture.challenge.repository.SharedAlbumRepository;
import com.accenture.challenge.repository.UserRepository;
import com.accenture.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserBusinessImpl implements UserBusiness {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SharedAlbumRepository sharedAlbumRepository;

    @Override
    public List<User> getAllUsers(String id, String username, String email) {
        List<User> userList = userService.getAllUsers(id, username, email);
        saveAllUsers(userList);
        return userList;
    }

    private void saveAllUsers(List<User> userList) {
        List<UserEntity> userEntityList = UserMapper.mapper.userListToUserEntityList(userList);
        userRepository.saveAll(userEntityList);
    }

    @Override
    public List<User> getUsersByPermissions(Long albumId, boolean read, boolean write) {
        List<SharedAlbumEntity> sharedAlbumEntityList = sharedAlbumRepository.findByAlbumIdAndReadAndWrite(albumId,
                read, write);

        List<SharedAlbum> sharedAlbumList =
                SharedAlbumMapper.mapper.sharedAlbumEntityListToSharedAlbumList(sharedAlbumEntityList);

        Set<Long> longSet = getAllIdsFromSharedAlbum(sharedAlbumList);

        return getAllUserById(longSet);
    }

    private Set<Long> getAllIdsFromSharedAlbum(List<SharedAlbum> sharedAlbumList) {
        Set<Long> longSet = new HashSet<>();
        for (SharedAlbum sharedAlbum : sharedAlbumList) {
            longSet.add(sharedAlbum.getUserIdSource());
            longSet.add(sharedAlbum.getUserIdDestination());
        }
        return longSet;
    }

    private List<User> getAllUserById(Set<Long> longSet) {
        List<User> userList = new ArrayList<>();
        for (Long userId : longSet) {
            Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
            if (optionalUserEntity.isPresent()) {
                User user = UserMapper.mapper.userEntityToUser(optionalUserEntity.get());
                userList.add(user);

            }
        }
        return userList;
    }

}
