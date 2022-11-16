package com.example.democonsumer.feign;

import com.example.democonsumer.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "demo-provider", path = "/user")
public interface UserApi {
    @GetMapping("/getUserById")
    UserEntity getUserById(@RequestParam("userId") Long userId);
}
