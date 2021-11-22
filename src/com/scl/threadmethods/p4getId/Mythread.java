package com.scl.threadmethods.p4getId;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:39
 */
public class Mythread extends Thread {
    @Override
    public void run() {

        System.out.println("获取一下线程的id是"+Thread.currentThread().getId());
    }
}