package com.example.demo01.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo01.constant.CommonConstants;
import com.example.demo01.entity.User;
import com.example.demo01.entity.UserEntity;
import com.example.demo01.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/11 15:17
 * @Desc:
 */
@Slf4j
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private UserTestService userTestService;

    public List<UserEntity> list() {
        log.info("######################## come in list method.");
        return userTestService.getUserList();
    }

    /**
     * 注册用户
     *
     * @param user 用户信息
     */
    @Transactional
    public void signUp(User user) {
        // 校验用户名
        List<User> users = userRepository.list(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, user.getUsername())
                .eq(User::getDelFlag, CommonConstants.NOT_DELETE));
        if (CollectionUtils.isNotEmpty(users)) {
            throw new RuntimeException("用户名已被占用，请再想一个😭");
        }

        // 添加用户
        userRepository.save(user);
    }

    /**
     * 登陆用户
     *
     * @param userInfo 账号密码
     */
    public boolean signIn(User userInfo) {
        User user = userRepository.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, userInfo.getUsername())
                .eq(User::getPassword, userInfo.getPassword())
                .eq(User::getDelFlag, CommonConstants.NOT_DELETE));

        return !Objects.isNull(user);
    }
}
