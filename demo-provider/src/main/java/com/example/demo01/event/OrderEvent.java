package com.example.demo01.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/26 20:17
 * @Desc: 订单事件
 */
public class OrderEvent extends ApplicationEvent {
    private String orderCode;
    private String goodsCode;
    private String redPacketCode;

    public OrderEvent(Object source, String orderCode, String goodsCode, String redPacketCode) {
        super(source);
        this.orderCode = orderCode;
        this.goodsCode = goodsCode;
        this.redPacketCode = redPacketCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getRedPacketCode() {
        return redPacketCode;
    }

    public void setRedPacketCode(String redPacketCode) {
        this.redPacketCode = redPacketCode;
    }
}
