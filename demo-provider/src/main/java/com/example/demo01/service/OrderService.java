package com.example.demo01.service;

import com.example.demo01.entity.UserEntity;
import com.example.demo01.event.MessageEvent;
import com.example.demo01.event.OrderEvent;
import com.example.demo01.util.ContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/26 20:36
 * @Desc:
 */
@Service
public class OrderService {
    @Resource
    private UserTestService userTestService;

    public void createOrder() {
        ApplicationContext context = ContextUtils.getApplicationContext();
        for (int i = 0; i < 10; i++) {
            String orderCode = "orderCode_" + i;
            String goodsCode = "goodsCode_" + i;
            String redPacketCode = "redPacketCode_" + i;
            Integer code = i;
            OrderEvent orderEvent = new OrderEvent(context, orderCode, goodsCode, redPacketCode);
            MessageEvent messageEvent = new MessageEvent(context, "message", code);
            context.publishEvent(orderEvent);
            context.publishEvent(messageEvent);
        }
    }

    @Transactional
    public boolean insertUser(String username, String password, Integer age) {
        ApplicationContext context = ContextUtils.getApplicationContext();
        // 事物方法内发布事件
        context.publishEvent(new MessageEvent(context, "message", 1));
        UserEntity userEntity = new UserEntity(7L, username, password, age);
        userTestService.addUser(userEntity);
        throw new RuntimeException("runtimeException");
    }
}
