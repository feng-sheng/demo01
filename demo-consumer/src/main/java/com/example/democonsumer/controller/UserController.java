package com.example.democonsumer.controller;

import com.example.democonsumer.entity.User;
import com.example.democonsumer.entity.UserEntity;
import com.example.democonsumer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/27 17:53
 * @Desc:
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/testReturn")
    public List<UserEntity> testReturn() {
        // 没有记录，返回了一个空集合，不是null，打印为0
        System.out.println(userService.testReturn().size());
        return userService.testReturn();
    }

    @GetMapping("/updateOne")
    public boolean updateOne() {
        return userService.updateOne();
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getById")
    public UserEntity getById(Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/updateBatch")
    public boolean updateBatch() {
        return userService.updateBatch();
    }

    @GetMapping("/updateBatch2")
    public boolean updateBatch2() {
        return userService.updateBatch2();
    }

    @GetMapping("/updateBatchById")
    public boolean updateBatchById() {
        return userService.updateBatchById();
    }

    @GetMapping("/saveBatch")
    public boolean saveBatch() {
        userService.saveBatch();
        return true;
    }

    @GetMapping("/logUserById")
    public UserEntity logUserById(Long userId) {
        return userService.logUserById(userId);
    }

    @GetMapping("/cacheUser")
    public String cacheUser() {
        userService.cacheUser();
        return "success";
    }

    @GetMapping("/getCacheUserByMap")
    public User getUserByMap(Integer userId) {
        return userService.getCacheUser(userId);
    }

    @GetMapping("/getCacheUserById")
    public User getUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getCacheUserById2")
    public User getUserById2(Integer userId) {
        return userService.getUserById2(userId);
    }

    @GetMapping("/removeCache")
    public String removeCache(Integer userId) {
        userService.removeCache(userId);
        return "success";
    }

    @GetMapping("/getUserByInternalMethod")
    public User getUserByInternalMethod(Integer userId) {
        return userService.getUserByInternalMethod(userId);
    }
}
