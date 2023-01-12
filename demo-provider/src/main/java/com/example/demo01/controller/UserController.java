package com.example.demo01.controller;

import com.example.demo01.entity.User;
import com.example.demo01.entity.UserEntity;
import com.example.demo01.service.UserService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("注册用户")
    @PostMapping("/signUp")
    public boolean signUp(@RequestBody User user) {
        userService.signUp(user);
        return true;
    }

    @ApiOperation("登陆用户")
    @PostMapping("/signIn")
    public boolean signIn(@RequestBody User user) {
        return userService.signIn(user);
    }

    @ApiOperation("测试接口")
    @GetMapping("/list")
    public List<UserEntity> list() {
        return userService.list();
    }


}
