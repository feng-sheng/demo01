package com.example.demo01.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/11 15:10
 * @Desc:
 */
@Data
public class BaseEntity {
    @ApiModelProperty("自增主键")
    private Long id;

    @ApiModelProperty("创建人")
    private Long createUser;

    @ApiModelProperty("创建人时间")
    private Date createTime;

    @ApiModelProperty("更新人")
    private Long updateUser;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("逻辑删除标志：0否，1是")
    private Integer delFlag;
}
