package com.example.demo01.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo01.entity.User;
import com.example.demo01.mapper.UserMapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: lifengsheng
 * @Date: 2022/11/2 16:45
 * @Desc:
 */
@Repository
public class UserRepository extends ServiceImpl<UserMapper, User> {

}
