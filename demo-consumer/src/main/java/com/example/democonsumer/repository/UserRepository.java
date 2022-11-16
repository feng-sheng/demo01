package com.example.democonsumer.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.democonsumer.entity.User;
import com.example.democonsumer.entity.UserEntity;
import com.example.democonsumer.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: lifengsheng
 * @Date: 2022/11/2 16:45
 * @Desc:
 */
@Repository
public class UserRepository extends ServiceImpl<UserMapper, UserEntity> {
    public List<UserEntity> getAll() {
        return baseMapper.getUserList();
    }
}
