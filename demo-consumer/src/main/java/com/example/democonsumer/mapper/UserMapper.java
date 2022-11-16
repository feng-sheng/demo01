package com.example.democonsumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.democonsumer.entity.UserEntity;

import java.util.List;

public interface UserMapper extends BaseMapper<UserEntity> {
    List<UserEntity> getUserList();

    UserEntity getUserById(Long id);

    int addUser(UserEntity user);

    int updateUser(UserEntity user);
}
