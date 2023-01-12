package com.example.demo01.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/11 15:10
 * @Desc:
 */
@Data
public class BaseEntity {
    @ApiModelProperty("自增主键")
    private Long id;

    @ApiModelProperty("逻辑删除标志：0否，1是")
    private Integer delFlag;
}
