package com.example.demo01.mapper;

import com.example.demo01.entity.UserEntity;

import java.util.List;

public interface UserTestMapper {
    List<UserEntity> getUserList();

    UserEntity getUserById(Long id);

    int addUser(UserEntity user);

    int updateUser(UserEntity user);
}
