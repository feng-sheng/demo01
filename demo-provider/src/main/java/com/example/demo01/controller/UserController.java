package com.example.demo01.controller;

import com.example.demo01.entity.User;
import com.example.demo01.entity.UserEntity;
import com.example.demo01.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/11 15:15
 * @Desc:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/signUp")
    public boolean signUp(@RequestBody User user) {
        userService.signUp(user);
        return true;
    }

    @PostMapping("/signIn")
    public boolean signIn(@RequestBody User user) {
        return userService.signIn(user);
    }

    @GetMapping("/list")
    public List<UserEntity> list() {
        return userService.list();
    }


}
