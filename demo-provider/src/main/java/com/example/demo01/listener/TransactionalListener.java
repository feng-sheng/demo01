package com.example.demo01.listener;

import com.example.demo01.event.MessageEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @Author: lifengsheng
 * @Date: 2022/10/8 19:12
 * @Desc:
 */
@Component
public class TransactionalListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void doSomething(MessageEvent event) {
        System.out.println("===============Occur error when access databases.");
    }
}
