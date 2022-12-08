package com.accenture.challenge.mapper;

import com.accenture.challenge.entity.UserEntity;
import com.accenture.challenge.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    List<UserEntity> userListToUserEntityList(List<User> userList);
}
