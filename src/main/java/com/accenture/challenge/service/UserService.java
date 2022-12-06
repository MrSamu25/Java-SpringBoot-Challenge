package com.accenture.challenge.service;

import com.accenture.challenge.model.user.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers(String id, String username, String email);
}
