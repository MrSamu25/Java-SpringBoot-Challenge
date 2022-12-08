package com.accenture.challenge.business;

import com.accenture.challenge.entity.UserEntity;
import com.accenture.challenge.mapper.UserMapper;
import com.accenture.challenge.model.user.User;
import com.accenture.challenge.repository.UserRepository;
import com.accenture.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserBusinessImpl implements UserBusiness {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

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
}
