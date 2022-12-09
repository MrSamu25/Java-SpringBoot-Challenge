package com.accenture.challenge.controller;

import com.accenture.challenge.business.UserBusiness;
import com.accenture.challenge.model.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserBusiness userBusiness;
    private List<User> userList;

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        User user = new User();
        userList.add(user);
    }

    @Test
    void shouldGetAllUsers() {
        given(userBusiness.getAllUsers(anyString(), anyString(), anyString())).willReturn(userList);

        List<User> userListResult = userController.getAllUsers(anyString(), anyString(), anyString());

        Assertions.assertEquals(1, userListResult.size());
    }

    @Test
    void shouldGetUsersByPermissions() {
        given(userBusiness.getUsersByPermissions(anyLong(), anyBoolean(), anyBoolean())).willReturn(userList);

        List<User> userListResult = userController.getUsersByPermissions(anyLong(), anyBoolean(), anyBoolean());

        Assertions.assertEquals(1, userListResult.size());
    }
}
