package com.example.demo01.listener;

import com.example.demo01.event.MessageEvent;
import com.example.demo01.event.OrderEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/27 08:59
 * @Desc:
 */
@Component
public class CommonListener {
    @Order(5)
    @EventListener
    public void listenEvent(OrderEvent event) {
        System.out.println("订单监听器监听到下单事件，订单号：" + event.getOrderCode());
    }

    @Order(4)
    @EventListener
    public void listenEvent2(OrderEvent event) {
        System.out.println("红包监听器监听到下单事件，红包编号：" + event.getOrderCode());
    }

    @Order(3)
    @EventListener
    public void listenEvent(MessageEvent event) {
        System.out.println("消息监听器监听到消息事件，消息码：" + event.getCode());
    }
}
