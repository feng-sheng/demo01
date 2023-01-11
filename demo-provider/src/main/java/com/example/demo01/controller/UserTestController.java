package com.example.demo01.controller;

import com.example.demo01.entity.UserEntity;
import com.example.demo01.service.UserTestService;
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
@RequestMapping("/user2")
@RestController
public class UserTestController {
    @Resource
    private UserTestService userTestService;

    @GetMapping("/getUserList")
    public List<UserEntity> getUserList() {
        return userTestService.getUserList();
    }

    @GetMapping("/getUserById")
    public UserEntity getUserById(Long id) {
        return userTestService.getUserById(id);
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody UserEntity user) {
        return userTestService.addUser(user);
    }

    @GetMapping("/getHeaders")
    public String getHeaders() {
        userTestService.getHeaders();
        return "true";
    }
}
