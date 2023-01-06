package com.example.demo01.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/29 09:48
 * @Desc: 这是一个测试注册中心的
 */
@RestController
@RefreshScope
public class ConfigCentreController {
    @Value("${config0}")
    private String config0;

    @Value("${config2}")
    private String config2;

    @Value("${commonConfig}")
    private String commonConfig;

    @GetMapping("/config")
    public String getConfig() {
        return config0 + ": " + config2 + ": " + commonConfig;
    }
}
