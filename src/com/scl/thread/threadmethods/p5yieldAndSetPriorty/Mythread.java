package com.scl.thread.threadmethods.p5yieldAndSetPriorty;

/**
 * @description: Thread.yield()线程的静态方法，表示放弃cpu争夺资源
 *
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:43
 */
public class Mythread extends Thread {

    long sum = 0;
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L; i++) {
           sum+=i;
            //Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程总计耗时"+(end-start));
    }
}