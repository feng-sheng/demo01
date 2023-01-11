package com.example.democonsumer.thread;

import com.example.democonsumer.utils.DateUtils;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/5 18:37
 * @Desc:
 */
@Service
public class RateLimiterTest {
    private static RateLimiter rateLimiter = RateLimiter.create(5);
    // acquire()是阻塞的且会一直等待到获取令牌为止，它有一个返回值为double型，意思是从阻塞开始到获取到令牌的等待时间，单位为秒
    // tryAcquire()从RateLimiter 获取许可，如果该许可可以在无延迟下的情况下立即获取得到的话
    // tryAcquire(long timeout, TimeUnit unit)
    // 从RateLimiter 获取许可如果该许可可以在不超过timeout的时间内获取得到的话，或者如果无法在timeout 过期之前获取得到许可的话，那么立即返回false（无需等待）

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                boolean b = rateLimiter.tryAcquire(3000, TimeUnit.MILLISECONDS);
                System.out.println(b);
                System.out.println(DateUtils.formatDate(new Date(), DateUtils.LONG_FORMAT));
            });
        }
        executorService.shutdown();
    }


}
