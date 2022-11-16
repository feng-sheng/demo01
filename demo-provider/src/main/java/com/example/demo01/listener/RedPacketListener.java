package com.example.demo01.listener;

import com.example.demo01.event.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/26 20:27
 * @Desc:
 */
//@Component
public class RedPacketListener implements ApplicationListener<OrderEvent>, Ordered {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println("红包监听器监听到下单事件，红包编号：" + event.getOrderCode());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
