package com.example.demo01.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/27 09:05
 * @Desc:
 */
public class MessageEvent extends ApplicationEvent {
    private String message;
    private Integer code;

    public MessageEvent(Object source, String message, Integer code) {
        super(source);
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
