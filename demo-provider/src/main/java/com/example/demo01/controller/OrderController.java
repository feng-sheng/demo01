package com.example.demo01.controller;

import com.example.demo01.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/26 20:35
 * @Desc:
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/createOrder")
    public void createOrder() {
        orderService.createOrder();
    }

    @GetMapping("/createOrder2")
    public boolean createOrder2() {
        return orderService.insertUser("abc", "123", 23);
    }
}
