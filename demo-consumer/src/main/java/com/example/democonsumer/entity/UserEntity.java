package com.example.democonsumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Date 2022/9/23
 * @Author lifengsheng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_test")
public class UserEntity implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Integer age;

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
