package com.scl.thread.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * aqs源码阅读使用
 */
public class AQSCODEREADdemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try{
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        }).start();



    }
}
