package com.example.demo01;

import com.example.demo01.entity.UserEntity;
import com.example.demo01.event.MessageEvent;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/27 09:20
 * @Desc:
 */
public class MainTest {

    @Test
    public void test3() {
        Integer num = null;
        System.out.println(String.valueOf(num));
        System.out.println(num.toString());
    }

    @Test
    public void test0() {
        UserEntity user = new UserEntity();
        user.setUsername("name1");
        user.setAge(123);
        UserEntity user1 = new UserEntity();
        user1.setUsername("name2");
        user1.setAge(111);
        user1.setId(10L);
        BeanUtils.copyProperties(user, user1, "username", "age","id");
        System.out.println(user);
        System.out.println(user1);
    }

    @Test
    public void test1() {
        String HOUSE_NAME = "%s-%sm²";
        BigDecimal bigDecimal = new BigDecimal("123.34");
        String format = String.format(HOUSE_NAME, "东户的", bigDecimal);
        System.out.println(format);
    }

    @Test
    public void test2() {
        String HOUSE_NAME = "%s-%sm²";
        double db = 120.12;
        BigDecimal bigDecimal = new BigDecimal(123.23);
        String s = bigDecimal.stripTrailingZeros().toPlainString();
        String s1 = bigDecimal.toPlainString();
        System.out.println(bigDecimal);
        System.out.println(s);
        System.out.println(s1);
        System.out.println("================");
        String format = String.format(HOUSE_NAME, "东户", bigDecimal);
        System.out.println(format);
    }
}
