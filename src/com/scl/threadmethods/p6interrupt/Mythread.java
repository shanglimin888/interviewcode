package com.scl.threadmethods.p6interrupt;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 15:00
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("sub thread"+i);
            if (Thread.currentThread().isInterrupted()){
                System.out.println("子线程被打断了");
                return;
            }
        }
    }
}