package com.example.democonsumer.service;

/**
 * @Author: lifengsheng
 * @Date: 2022/11/22 10:05
 * @Desc:
 */
public interface TestInter {
    default void print() {
        System.out.println("############# come from interface method");
    }

    static void print2() {
        System.out.println("############# come from static method");
    }
}
