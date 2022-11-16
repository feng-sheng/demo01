package com.example.demo01.listener;

import com.example.demo01.event.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/26 20:24
 * @Desc: 订单监听器
 */
//@Component
public class OrderListener implements ApplicationListener<OrderEvent>, Ordered {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        String threadName = Thread.currentThread().getName();
        //System.out.println("当前处理线程是：" + threadName);
        System.out.println("订单监听器监听到下单事件，订单号：" + event.getOrderCode());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
