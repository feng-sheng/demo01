package com.example.democonsumer.controller;

import com.example.democonsumer.service.RateLimiterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/5 18:35
 * @Desc:
 */
@RestController
public class RateLimiterController {
    @Resource
    private RateLimiterService rateLimiterService;


}
