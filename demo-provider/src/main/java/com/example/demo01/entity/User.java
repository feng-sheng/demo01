package com.example.demo01.entity;

import lombok.Data;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/11 15:03
 * @Desc: 用户表
 */
@Data
public class User extends BaseEntity {
    private String username;

    private String password;

    private String nickname;

    private String phoneNumber;

    private String email;

    private Integer sex;

    private Integer age;

    private String authority;
}
