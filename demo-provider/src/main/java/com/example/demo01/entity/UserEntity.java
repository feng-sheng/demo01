package com.example.demo01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description
 * @Date 2022/9/23
 * @Author lifengsheng
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String username;
    private String password;
    private int age;

    public UserEntity(Long id, String username, String password, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public UserEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
