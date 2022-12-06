package com.accenture.challenge.business;

import com.accenture.challenge.model.user.User;

import java.util.List;

public interface UserBusiness {
    List<User> getAllUsers(String id, String username, String email);
}
