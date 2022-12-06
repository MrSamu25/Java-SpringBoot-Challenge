package com.accenture.challenge.controller;

import com.accenture.challenge.business.UserBusiness;
import com.accenture.challenge.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam(required = false) String id,
                                  @RequestParam(required = false) String username,
                                  @RequestParam(required = false) String email) {
        return userBusiness.getAllUsers(id, username, email);
    }
}
