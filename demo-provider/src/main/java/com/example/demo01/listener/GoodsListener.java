package com.example.demo01.listener;

import com.example.demo01.event.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/26 20:27
 * @Desc:
 */
//@Component
public class GoodsListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println("商品监听器监听到下单事件，商品编号：" + event.getOrderCode());
    }
}
