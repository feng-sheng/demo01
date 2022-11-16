package com.example.democonsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: lifengsheng
 * @Date: 2022/10/20 20:14
 * @Desc:
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;

    public User() {
    }
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
