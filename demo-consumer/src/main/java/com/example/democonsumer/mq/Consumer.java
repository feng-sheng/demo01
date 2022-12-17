package com.example.democonsumer.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @Author: lifengsheng
 * @Date: 2022/12/16 16:04
 * @Desc:
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        // 设置消费者组名
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("ConsumerGroupName");
        // 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 指定nameServer的地址
        pushConsumer.setNamesrvAddr("124.220.181.230:9876");
        // 指定订阅的topic及tag表达式
        pushConsumer.subscribe("TopicTest", "*");

        pushConsumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            MessageExt messageExt = list.get(0);
            System.out.printf("Consume message [%s],tagName[%s]%n",
                    new String(messageExt.getBody()),
                    messageExt.getTags());
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        // 启动消费者实例
        pushConsumer.start();
        System.out.println("################## consumer started...");
    }
}
