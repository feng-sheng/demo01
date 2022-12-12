package com.example.democonsumer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: lifengsheng
 * @Date: 2022/12/1 16:46
 * @Desc:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonBody implements Serializable {
    private Integer code;

    private LocalDateTime startTime;

    private List<InnerBody> list;

    @Data
    public static class InnerBody {
        private Integer id;
        private String name;
    }
}
