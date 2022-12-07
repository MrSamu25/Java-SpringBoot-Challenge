package com.accenture.challenge.business;

import com.accenture.challenge.model.user.User;
import com.accenture.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBusinessImpl implements UserBusiness {
    @Autowired
    private UserService userService;

    @Override
    public List<User> getAllUsers(String id, String username, String email) {
        return userService.getAllUsers(id, username, email);
    }
}
