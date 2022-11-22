package com.example.democonsumer.service.impl;

import com.example.democonsumer.service.TestInter;

/**
 * @Author: lifengsheng
 * @Date: 2022/11/22 10:07
 * @Desc:
 */
public class TestInterImpl implements TestInter {
    public void print() {
        System.out.println("############# come from class method");
    }

    static void print2() {
        System.out.println("############# come from class static method");
    }

    public static void main(String[] args) {
        TestInter.print2();
        System.out.println("==================");
        TestInter testInter = new TestInterImpl();
        testInter.print();
        System.out.println("==================");
        TestInterImpl testInter1 = new TestInterImpl();
        testInter1.print();
        print2();
    }
}
