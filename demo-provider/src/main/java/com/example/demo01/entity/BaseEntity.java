package com.example.demo01.entity;

import lombok.Data;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/11 15:10
 * @Desc:
 */
@Data
public class BaseEntity {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 逻辑删除标志：0否，1是
     */
    private Integer delFlag;
}
