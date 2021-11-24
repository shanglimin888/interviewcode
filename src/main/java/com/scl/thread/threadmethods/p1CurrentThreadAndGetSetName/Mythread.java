package com.scl.thread.threadmethods.p1CurrentThreadAndGetSetName;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:15
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程是"+Thread.currentThread().getName());
    }
}