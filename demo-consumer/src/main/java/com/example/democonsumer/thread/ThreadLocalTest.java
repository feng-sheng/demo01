package com.example.democonsumer.thread;

import com.example.democonsumer.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lifengsheng
 * @Date: 2022/11/28 19:11
 * @Desc: 测试111
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
         ThreadLocal<User> threadLocalObj = new InheritableThreadLocal<>();
         User user = new User();
         user.setName("小王");
         threadLocalObj.set(user);


         Runnable run = () -> {
             System.out.println("current thread is: " + Thread.currentThread().getName());
             System.out.println(threadLocalObj.get().getName());
             threadLocalObj.get().setName("老李");
             System.out.println("==================");
         };
         new Thread(run).start();
        Thread.sleep(2000);
        System.out.println("current thread is: " + Thread.currentThread().getName());
        System.out.println(threadLocalObj.get().getName());

    }
}
