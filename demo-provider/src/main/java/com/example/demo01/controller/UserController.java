package com.example.demo01.controller;

import com.example.demo01.entity.UserEntity;
import com.example.demo01.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description
 * @Date 2022/9/23
 * @Author lifengsheng
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/getUserList")
    public List<UserEntity> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/getUserById")
    public UserEntity getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }

    @GetMapping("/getHeaders")
    public String getHeaders() {
        userService.getHeaders();
        return "true";
    }
}
