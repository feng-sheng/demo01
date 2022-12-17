package com.example.demo01.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.Semaphore;

/**
 * @Author: lifengsheng
 * @Date: 2022/12/16 14:47
 * @Desc:
 */
public class Producer {
    private static int count = 300;

    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException, RemotingException {
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        // 指定nameServer的地址
        producer.setNamesrvAddr("124.220.181.230:9876");
        //producer.setVipChannelEnabled(false);
        // 启动实例
        producer.start();
        //final Semaphore semaphore = new Semaphore(0);

        for (int i = 0; i < count; i++) {
            Thread.sleep(3000);
            Message message = new Message(
                    "TopicTest",
                    "test_tag",
                    ("Hello RocketMQ-abc " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(String.format("message [%s] send success!", new String(message.getBody())));
                    //semaphore.release();
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("################# occur error...");
                    throwable.printStackTrace();
                }
            });
        }

        //semaphore.acquire(count);
        //关闭生产者，释放资源
        producer.shutdown();
    }
}
